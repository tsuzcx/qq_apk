package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.qqmail.e.d;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.model.u;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.ao;
import java.util.ArrayList;
import java.util.List;

public class MailAttachListLinearLayout
  extends LinearLayout
{
  private String Njg;
  private List<String> Noy;
  private Context context;
  
  public MailAttachListLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(123105);
    this.Noy = new ArrayList();
    this.context = paramContext;
    AppMethodBeat.o(123105);
  }
  
  public final void jC(List<Bundle> paramList)
  {
    AppMethodBeat.i(266990);
    int i = 0;
    if (i < paramList.size())
    {
      View localView = View.inflate(this.context, e.f.readmail_attach_item, null);
      Bundle localBundle = (Bundle)paramList.get(i);
      if (i == paramList.size() - 1) {
        localView.setBackgroundResource(e.d.mail_attach_list_item3);
      }
      for (;;)
      {
        addView(localView);
        final String str = localBundle.getString("attach_name", "");
        this.Noy.add(str);
        final int j = localBundle.getInt("attach_size", 0);
        ((TextView)localView.findViewById(e.e.readmail_attach_item_name_tv)).setText(str);
        ((TextView)localView.findViewById(e.e.readmail_attach_item_size_tv)).setText(Util.getSizeKB(j));
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(123104);
            Object localObject = new b();
            ((b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/MailAttachListLinearLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
            localObject = new Intent(MailAttachListLinearLayout.a(MailAttachListLinearLayout.this), AttachDownloadPage.class);
            ((Intent)localObject).putExtra("attach_name", str);
            ((Intent)localObject).putExtra("mail_id", MailAttachListLinearLayout.b(MailAttachListLinearLayout.this));
            ((Intent)localObject).putExtra("attach_id", this.Noz);
            ((Intent)localObject).putExtra("total_size", j);
            ((Intent)localObject).putExtra("attach_url", this.NoA);
            ((Intent)localObject).putExtra("is_compress", MailAttachListLinearLayout.aSu(this.NoA));
            ((Intent)localObject).putExtra("is_preview", 1);
            ((Intent)localObject).putExtra("qqmail_cookie", ao.getCookie(u.gEa()));
            paramAnonymousView = MailAttachListLinearLayout.a(MailAttachListLinearLayout.this);
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/qqmail/ui/MailAttachListLinearLayout$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/qqmail/ui/MailAttachListLinearLayout$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAttachListLinearLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(123104);
          }
        });
        ((ImageView)localView.findViewById(e.e.readmail_attach_item_icon_iv)).setImageResource(FileExplorerUI.brA(str));
        i += 1;
        break;
        localView.setBackgroundResource(e.d.mail_attach_list_item2);
      }
    }
    AppMethodBeat.o(266990);
  }
  
  public void setMailId(String paramString)
  {
    this.Njg = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAttachListLinearLayout
 * JD-Core Version:    0.7.0.1
 */