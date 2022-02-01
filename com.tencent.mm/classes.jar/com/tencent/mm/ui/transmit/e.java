package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;

public final class e
{
  a afPc;
  com.tencent.mm.ui.widget.a.e pRv;
  
  private e(a parama)
  {
    this.afPc = parama;
  }
  
  public static final e a(Context paramContext, WXMediaMessage paramWXMediaMessage, g paramg, a parama)
  {
    AppMethodBeat.i(250931);
    e locale = new e(parama);
    if (paramWXMediaMessage.thumbData == null) {}
    for (parama = null;; parama = BitmapUtil.decodeByteArray(paramWXMediaMessage.thumbData)) {
      switch (paramWXMediaMessage.mediaObject.type())
      {
      default: 
        Log.e("MicroMsg.SendAppMessage", "unkown app message type, skipped, type=" + paramWXMediaMessage.mediaObject.type());
        AppMethodBeat.o(250931);
        return null;
      }
    }
    parama = View.inflate(paramContext, R.i.ger, null);
    ((TextView)parama.findViewById(R.h.title_tv)).setText(paramWXMediaMessage.title);
    paramWXMediaMessage = parama;
    for (;;)
    {
      ((TextView)paramWXMediaMessage.findViewById(R.h.source_tv)).setText(h.a(paramContext, paramg, null));
      locale.pRv = k.a(paramContext, null, paramWXMediaMessage, paramContext.getString(R.l.app_send), paramContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(39413);
          e.this.afPc.jDI();
          AppMethodBeat.o(39413);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(39414);
          paramAnonymousDialogInterface = e.this;
          if (paramAnonymousDialogInterface.pRv != null)
          {
            paramAnonymousDialogInterface.pRv.dismiss();
            paramAnonymousDialogInterface.pRv = null;
          }
          paramAnonymousDialogInterface.afPc.jDI();
          AppMethodBeat.o(39414);
        }
      });
      AppMethodBeat.o(250931);
      return locale;
      View localView = View.inflate(paramContext, R.i.geq, null);
      ((ImageView)localView.findViewById(R.h.thumb_iv)).setImageBitmap(parama);
      ((TextView)localView.findViewById(R.h.title_tv)).setText(paramWXMediaMessage.title);
      paramWXMediaMessage = localView;
      continue;
      localView = View.inflate(paramContext, R.i.gep, null);
      ((ImageView)localView.findViewById(R.h.thumb_iv)).setImageBitmap(parama);
      parama = (TextView)localView.findViewById(R.h.title_tv);
      TextView localTextView = (TextView)localView.findViewById(R.h.desc_tv);
      parama.setText(paramWXMediaMessage.title);
      localTextView.setText(paramWXMediaMessage.description);
      paramWXMediaMessage = localView;
      continue;
      localView = View.inflate(paramContext, R.i.gep, null);
      ((ImageView)localView.findViewById(R.h.thumb_iv)).setImageBitmap(parama);
      parama = (TextView)localView.findViewById(R.h.title_tv);
      localTextView = (TextView)localView.findViewById(R.h.desc_tv);
      parama.setText(paramWXMediaMessage.title);
      localTextView.setText(paramWXMediaMessage.description);
      paramWXMediaMessage = localView;
      continue;
      localView = View.inflate(paramContext, R.i.gep, null);
      ((ImageView)localView.findViewById(R.h.thumb_iv)).setImageBitmap(parama);
      parama = (TextView)localView.findViewById(R.h.title_tv);
      localTextView = (TextView)localView.findViewById(R.h.desc_tv);
      parama.setText(paramWXMediaMessage.title);
      localTextView.setText(paramWXMediaMessage.description);
      paramWXMediaMessage = localView;
      continue;
      localView = View.inflate(paramContext, R.i.gep, null);
      ((ImageView)localView.findViewById(R.h.thumb_iv)).setImageBitmap(parama);
      parama = (TextView)localView.findViewById(R.h.title_tv);
      localTextView = (TextView)localView.findViewById(R.h.desc_tv);
      parama.setText(paramWXMediaMessage.title);
      localTextView.setText(paramWXMediaMessage.description);
      paramWXMediaMessage = localView;
      continue;
      localView = View.inflate(paramContext, R.i.gep, null);
      ((ImageView)localView.findViewById(R.h.thumb_iv)).setImageBitmap(parama);
      parama = (TextView)localView.findViewById(R.h.title_tv);
      localTextView = (TextView)localView.findViewById(R.h.desc_tv);
      parama.setText(paramWXMediaMessage.title);
      localTextView.setText(paramWXMediaMessage.description);
      paramWXMediaMessage = localView;
    }
  }
  
  public static abstract interface a
  {
    public abstract void jDI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.e
 * JD-Core Version:    0.7.0.1
 */