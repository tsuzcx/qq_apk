package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

public final class u
{
  SharedPreferences dnD;
  public LinearLayout jiW = null;
  long jyG = -1L;
  Context mContext;
  public String nju;
  String njv;
  String njw;
  public FrameLayout vkA;
  public TextView vkB;
  public ImageView vkC;
  u.a vkD = u.a.vkO;
  public int vkE = -1;
  public boolean vkF;
  String vkG = null;
  public String vkH;
  public View.OnClickListener vkI = new u.1(this);
  public View.OnClickListener vkJ = new u.2(this);
  private i.a vkK = new u.7(this);
  public ChatFooterCustom vky;
  public FrameLayout vkz;
  
  public u(ChatFooterCustom paramChatFooterCustom)
  {
    this.mContext = paramChatFooterCustom.getContext();
    this.vky = paramChatFooterCustom;
  }
  
  public final void cCQ()
  {
    if (this.vkD == u.a.vkS)
    {
      this.vkC.setImageResource(R.k.promo_icon_qqmail);
      return;
    }
    this.vkC.setImageResource(R.k.promo_icon_qqmail_uninstall);
  }
  
  public final void cCR()
  {
    Object localObject;
    if (p.o(this.mContext, "com.tencent.androidqqmail")) {
      localObject = u.a.vkS;
    }
    for (;;)
    {
      this.vkD = ((u.a)localObject);
      cCQ();
      y.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initRightBtnTv: status:%s]", new Object[] { this.vkD.toString() });
      switch (u.8.vkN[this.vkD.ordinal()])
      {
      default: 
        i.a(this.vkK);
        return;
        this.dnD = this.mContext.getSharedPreferences("QQMAIL", 4);
        this.jyG = this.dnD.getLong("qqmail_downloadid", -1L);
        if (this.jyG < 0L)
        {
          if (bk.bl(this.nju)) {
            localObject = u.a.vkT;
          } else {
            localObject = u.a.vkP;
          }
        }
        else
        {
          localObject = d.aFP().dd(this.jyG);
          int i = ((FileDownloadTaskInfo)localObject).status;
          this.vkG = ((FileDownloadTaskInfo)localObject).path;
          switch (i)
          {
          case 2: 
          default: 
            if (bk.bl(this.nju)) {
              localObject = u.a.vkT;
            }
            break;
          case 3: 
            if (e.bK(this.vkG)) {
              localObject = u.a.vkR;
            } else if (bk.bl(this.nju)) {
              localObject = u.a.vkT;
            } else {
              localObject = u.a.vkP;
            }
            break;
          case 1: 
            localObject = u.a.vkQ;
            continue;
            localObject = u.a.vkP;
          }
        }
        break;
      }
    }
    this.vkB.setText(R.l.chatfooter_mail_install);
    return;
    this.vkB.setText(R.l.chatfooter_mail_downloading);
    return;
    i.a(this.vkK);
  }
  
  public final void cCS()
  {
    if (this.vkE == 0)
    {
      this.vkB.setText(R.l.chatfooter_mail_without_unread_count);
      return;
    }
    if (this.vkE > 99)
    {
      this.vkB.setText(R.l.chatfooter_mail_with_unread_count_over_99);
      return;
    }
    this.vkB.setText(String.format(a.ac(this.mContext, R.l.chatfooter_mail_with_unread_count), new Object[] { Integer.valueOf(this.vkE) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.u
 * JD-Core Version:    0.7.0.1
 */