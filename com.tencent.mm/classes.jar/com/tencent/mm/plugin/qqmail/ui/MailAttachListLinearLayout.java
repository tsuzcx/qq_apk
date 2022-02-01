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
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.c;
import java.util.ArrayList;
import java.util.List;

public class MailAttachListLinearLayout
  extends LinearLayout
{
  private String BqZ;
  private List<String> Bwp;
  private Context context;
  
  public MailAttachListLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(123105);
    this.Bwp = new ArrayList();
    this.context = paramContext;
    AppMethodBeat.o(123105);
  }
  
  public final void fY(List<Bundle> paramList)
  {
    AppMethodBeat.i(198719);
    int i = 0;
    if (i < paramList.size())
    {
      View localView = View.inflate(this.context, 2131496040, null);
      Bundle localBundle = (Bundle)paramList.get(i);
      if (i == paramList.size() - 1) {
        localView.setBackgroundResource(2131233846);
      }
      for (;;)
      {
        addView(localView);
        final String str = localBundle.getString("attach_name", "");
        this.Bwp.add(str);
        final int j = localBundle.getInt("attach_size", 0);
        ((TextView)localView.findViewById(2131306578)).setText(str);
        ((TextView)localView.findViewById(2131306580)).setText(Util.getSizeKB(j));
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(123104);
            Object localObject = new b();
            ((b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAttachListLinearLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
            localObject = new Intent(MailAttachListLinearLayout.a(MailAttachListLinearLayout.this), AttachDownloadPage.class);
            ((Intent)localObject).putExtra("attach_name", str);
            ((Intent)localObject).putExtra("mail_id", MailAttachListLinearLayout.b(MailAttachListLinearLayout.this));
            ((Intent)localObject).putExtra("attach_id", this.Bwq);
            ((Intent)localObject).putExtra("total_size", j);
            ((Intent)localObject).putExtra("attach_url", this.Bwr);
            ((Intent)localObject).putExtra("is_compress", MailAttachListLinearLayout.aKL(this.Bwr));
            ((Intent)localObject).putExtra("is_preview", 1);
            ((Intent)localObject).putExtra("qqmail_cookie", c.hsp().getCookie(v.eGq()));
            paramAnonymousView = MailAttachListLinearLayout.a(MailAttachListLinearLayout.this);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/qqmail/ui/MailAttachListLinearLayout$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/qqmail/ui/MailAttachListLinearLayout$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAttachListLinearLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(123104);
          }
        });
        ((ImageView)localView.findViewById(2131306577)).setImageResource(FileExplorerUI.bfq(str));
        i += 1;
        break;
        localView.setBackgroundResource(2131233845);
      }
    }
    AppMethodBeat.o(198719);
  }
  
  public void setMailId(String paramString)
  {
    this.BqZ = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAttachListLinearLayout
 * JD-Core Version:    0.7.0.1
 */