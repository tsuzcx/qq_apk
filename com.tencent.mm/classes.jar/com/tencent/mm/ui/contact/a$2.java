package com.tencent.mm.ui.contact;

import android.content.res.ColorStateList;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.f;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.AddressView.a;

final class a$2
  implements AddressView.a
{
  a$2(a parama, f paramf, a.b paramb) {}
  
  public final CharSequence NT(int paramInt)
  {
    AppMethodBeat.i(156716);
    Object localObject3 = this.Aag.ywx;
    if (localObject3 == null)
    {
      try
      {
        localObject1 = this.Aag.Of();
        localObject3 = this.Aag.field_descWordingId;
        localObject3 = ((b)g.E(b.class)).bd(this.Aag.field_openImAppid, (String)localObject3);
        if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
          break label442;
        }
        localObject3 = "@".concat(String.valueOf(localObject3));
        int i = com.tencent.mm.cb.a.ao(a.a(this.Aaf), 2131427564);
        localObject4 = new TextView(a.b(this.Aaf));
        ((TextView)localObject4).getPaint().setTextSize(i);
        f = ((TextView)localObject4).getPaint().measureText(" ".concat(String.valueOf(localObject3)));
        ((TextView)localObject4).getPaint().setTextSize(this.Aah.nYV.getNickNameSize());
        if (f < paramInt * 0.6D) {
          break label420;
        }
        localObject1 = TextUtils.ellipsize((CharSequence)localObject1, ((TextView)localObject4).getPaint(), (float)(paramInt * 0.4D), TextUtils.TruncateAt.END);
        f = ((TextView)localObject4).getPaint().measureText(((CharSequence)localObject1).toString());
        ((TextView)localObject4).getPaint().setTextSize(i);
        localObject3 = TextUtils.ellipsize((CharSequence)localObject3, ((TextView)localObject4).getPaint(), paramInt - f - 20.0F, TextUtils.TruncateAt.END);
        localObject4 = j.b(a.c(this.Aaf), localObject1 + " " + localObject3);
        ColorStateList localColorStateList = com.tencent.mm.cb.a.l(a.d(this.Aaf), 2131690198);
        ((SpannableString)localObject4).setSpan(new TextAppearanceSpan(null, 0, i, localColorStateList, localColorStateList), ((CharSequence)localObject1).length() + 1, ((CharSequence)localObject1).length() + 1 + ((CharSequence)localObject3).length(), 33);
        ((SpannableString)localObject4).setSpan(new com.tencent.mm.ce.a(i), ((CharSequence)localObject1).length() + 1, ((CharSequence)localObject1).length() + 1 + ((CharSequence)localObject3).length(), 33);
        localObject1 = localObject4;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject4;
          float f;
          label387:
          localObject2 = null;
        }
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = "";
      }
      this.Aah.nYV.setName((CharSequence)localObject3);
    }
    for (;;)
    {
      AppMethodBeat.o(156716);
      return localObject3;
      label420:
      localObject1 = TextUtils.ellipsize((CharSequence)localObject1, ((TextView)localObject4).getPaint(), paramInt - f, TextUtils.TruncateAt.END);
      break;
      label442:
      localObject1 = ((b)g.E(b.class)).e(ah.getContext(), (String)localObject1, com.tencent.mm.cb.a.ao(a.e(this.Aaf), 2131427809));
      break label387;
      Object localObject2;
      this.Aah.nYV.setName((CharSequence)localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.2
 * JD-Core Version:    0.7.0.1
 */