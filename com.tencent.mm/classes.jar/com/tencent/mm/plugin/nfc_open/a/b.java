package com.tencent.mm.plugin.nfc_open.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/nfc_open/logic/DeepLinkNfcProcessor;", "Lcom/tencent/mm/plugin/nfc_open/logic/INfcProcessor;", "()V", "name", "", "getName", "()Ljava/lang/String;", "priority", "", "getPriority", "()I", "parseMessages", "", "Landroid/nfc/NdefMessage;", "intent", "Landroid/content/Intent;", "parseMessages1", "parseMessages2", "parseUris", "Landroid/net/Uri;", "message", "messages", "parseUris1", "parseUris2", "process", "", "context", "Landroid/content/Context;", "isDeepLinkToMe", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements c
{
  public static final b.a Mts;
  private final String name = "DeepLink";
  private final int priority;
  
  static
  {
    AppMethodBeat.i(261800);
    Mts = new b.a((byte)0);
    AppMethodBeat.o(261800);
  }
  
  private static List<Uri> b(NdefMessage paramNdefMessage)
  {
    int k = 1;
    int j = 0;
    AppMethodBeat.i(261793);
    paramNdefMessage = paramNdefMessage.getRecords();
    int i = k;
    if (paramNdefMessage != null)
    {
      if (paramNdefMessage.length != 0) {
        break label51;
      }
      i = 1;
      if (i == 0) {
        break label56;
      }
    }
    label51:
    label56:
    for (i = k;; i = 0)
    {
      if (i == 0) {
        break label61;
      }
      Log.i("MicroMsg.Nfc.DeepLinkNfcProcessor", "parseUri1, records is empty");
      AppMethodBeat.o(261793);
      return null;
      i = 0;
      break;
    }
    label61:
    ArrayList localArrayList = new ArrayList(paramNdefMessage.length);
    s.s(paramNdefMessage, "records");
    k = paramNdefMessage.length;
    i = j;
    while (i < k)
    {
      Uri localUri = paramNdefMessage[i];
      j = i + 1;
      localUri = localUri.toUri();
      i = j;
      if (localUri != null)
      {
        localArrayList.add(localUri);
        i = j;
      }
    }
    if (localArrayList.isEmpty()) {
      Log.i("MicroMsg.Nfc.DeepLinkNfcProcessor", "parseUri1, uris is empty");
    }
    paramNdefMessage = (List)localArrayList;
    AppMethodBeat.o(261793);
    return paramNdefMessage;
  }
  
  private static List<Uri> c(NdefMessage paramNdefMessage)
  {
    AppMethodBeat.i(261797);
    NdefRecord[] arrayOfNdefRecord = paramNdefMessage.getRecords();
    if (arrayOfNdefRecord != null)
    {
      if (arrayOfNdefRecord.length != 0) {
        break label48;
      }
      i = 1;
      if (i == 0) {
        break label53;
      }
    }
    label48:
    label53:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label58;
      }
      Log.i("MicroMsg.Nfc.DeepLinkNfcProcessor", "parseUris2, records is empty");
      AppMethodBeat.o(261797);
      return null;
      i = 0;
      break;
    }
    label58:
    ArrayList localArrayList = new ArrayList(arrayOfNdefRecord.length);
    s.s(arrayOfNdefRecord, "records");
    int k = arrayOfNdefRecord.length;
    i = 0;
    label137:
    label158:
    label287:
    label292:
    label327:
    for (;;)
    {
      if (i < k)
      {
        paramNdefMessage = arrayOfNdefRecord[i];
        i += 1;
        if ((1 == paramNdefMessage.getTnf()) && (Arrays.equals(NdefRecord.RTD_TEXT, paramNdefMessage.getType())))
        {
          byte[] arrayOfByte = paramNdefMessage.getPayload();
          int j;
          int m;
          int n;
          String str;
          if ((arrayOfByte == null) || (arrayOfByte.length == 0))
          {
            j = 1;
            if (j != 0) {
              break label327;
            }
            m = arrayOfByte[0];
            if ((m & 0x80) != 0) {
              break label287;
            }
            j = 1;
            m &= 0x3F;
            n = arrayOfByte.length;
            s.s(arrayOfByte, "payload");
            paramNdefMessage = StandardCharsets.US_ASCII;
            s.s(paramNdefMessage, "US_ASCII");
            str = new String(arrayOfByte, 1, m, paramNdefMessage);
            if (j == 0) {
              break label292;
            }
          }
          for (paramNdefMessage = StandardCharsets.UTF_8;; paramNdefMessage = StandardCharsets.UTF_16)
          {
            s.s(paramNdefMessage, "if (isUtf8) StandardChar…e StandardCharsets.UTF_16");
            paramNdefMessage = new String(arrayOfByte, m + 1, n - 1 - m, paramNdefMessage);
            Log.i("MicroMsg.Nfc.DeepLinkNfcProcessor", "parseUris2, languageCode: " + str + ", text: " + paramNdefMessage);
            localArrayList.add(Uri.parse(paramNdefMessage));
            break;
            j = 0;
            break label137;
            j = 0;
            break label158;
          }
        }
      }
      else
      {
        if (localArrayList.isEmpty()) {
          Log.i("MicroMsg.Nfc.DeepLinkNfcProcessor", "parseUris2, uris is empty");
        }
        paramNdefMessage = (List)localArrayList;
        AppMethodBeat.o(261797);
        return paramNdefMessage;
      }
    }
  }
  
  private static List<Uri> jm(List<NdefMessage> paramList)
  {
    AppMethodBeat.i(261787);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    label70:
    while (localIterator.hasNext())
    {
      NdefMessage localNdefMessage = (NdefMessage)localIterator.next();
      paramList = b(localNdefMessage);
      if (paramList == null) {
        paramList = c(localNdefMessage);
      }
      for (;;)
      {
        if (paramList == null) {
          break label70;
        }
        localArrayList.addAll((Collection)paramList);
        break;
      }
    }
    if (localArrayList.isEmpty())
    {
      Log.i("MicroMsg.Nfc.DeepLinkNfcProcessor", "parseUris, uris is empty");
      AppMethodBeat.o(261787);
      return null;
    }
    paramList = (List)localArrayList;
    AppMethodBeat.o(261787);
    return paramList;
  }
  
  public final boolean aD(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(261806);
    s.u(paramContext, "context");
    s.u(paramIntent, "intent");
    Object localObject2 = paramIntent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
    int i;
    if (localObject2 != null)
    {
      if (localObject2.length == 0)
      {
        i = 1;
        if (i == 0) {
          break label108;
        }
      }
    }
    else
    {
      i = 1;
      label44:
      if (i == 0) {
        break label113;
      }
      Log.i("MicroMsg.Nfc.DeepLinkNfcProcessor", "parseMessage1, rawMessages is empty");
      localObject2 = null;
      label58:
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        paramIntent = (Tag)paramIntent.getParcelableExtra("android.nfc.extra.TAG");
        if (paramIntent != null) {
          break label205;
        }
        Log.i("MicroMsg.Nfc.DeepLinkNfcProcessor", "parseMessage2, tag is null");
        localObject1 = null;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label281;
      }
      AppMethodBeat.o(261806);
      return false;
      i = 0;
      break;
      label108:
      i = 0;
      break label44;
      label113:
      localObject1 = new ArrayList(localObject2.length);
      localObject2 = kotlin.g.b.c.ao((Object[])localObject2);
      while (((Iterator)localObject2).hasNext())
      {
        Parcelable localParcelable = (Parcelable)((Iterator)localObject2).next();
        if ((localParcelable instanceof NdefMessage)) {
          ((ArrayList)localObject1).add(localParcelable);
        }
      }
      if (((ArrayList)localObject1).isEmpty())
      {
        Log.i("MicroMsg.Nfc.DeepLinkNfcProcessor", "parseMessage1, messages is empty");
        localObject2 = null;
        break label58;
      }
      localObject2 = (List)localObject1;
      break label58;
      label205:
      if (Ndef.get(paramIntent) == null)
      {
        Log.i("MicroMsg.Nfc.DeepLinkNfcProcessor", "parseMessage2, ndef is not in tag's techList");
        localObject1 = null;
      }
      else
      {
        paramIntent = Ndef.get(paramIntent);
        if (paramIntent == null)
        {
          Log.i("MicroMsg.Nfc.DeepLinkNfcProcessor", "parseMessage2, ndef is null");
          localObject1 = null;
        }
        else
        {
          paramIntent = paramIntent.getCachedNdefMessage();
          if (paramIntent == null)
          {
            Log.i("MicroMsg.Nfc.DeepLinkNfcProcessor", "parseMessage1, message is null");
            localObject1 = null;
          }
          else
          {
            localObject1 = p.listOf(paramIntent);
          }
        }
      }
    }
    label281:
    paramIntent = ((Collection)localObject1).toArray(new NdefMessage[0]);
    if (paramIntent == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(261806);
      throw paramContext;
    }
    paramIntent = Arrays.toString(paramIntent);
    s.s(paramIntent, "java.util.Arrays.toString(this)");
    Log.d("MicroMsg.Nfc.DeepLinkNfcProcessor", s.X("process, messages: ", paramIntent));
    paramIntent = jm((List)localObject1);
    if (paramIntent == null)
    {
      AppMethodBeat.o(261806);
      return false;
    }
    Object localObject1 = ((Collection)paramIntent).toArray(new Uri[0]);
    if (localObject1 == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(261806);
      throw paramContext;
    }
    localObject1 = Arrays.toString((Object[])localObject1);
    s.s(localObject1, "java.util.Arrays.toString(this)");
    Log.i("MicroMsg.Nfc.DeepLinkNfcProcessor", s.X("process, uris: ", localObject1));
    localObject1 = ((Iterable)paramIntent).iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      paramIntent = ((Iterator)localObject1).next();
      localObject2 = g.boS(((Uri)paramIntent).toString());
      Log.i("MicroMsg.Nfc.DeepLinkNfcProcessor", s.X("isDeepLinkToMe#Uri, url: ", localObject2));
      s.s(localObject2, "url");
    } while (!n.U(n.bq((CharSequence)localObject2).toString(), "weixin://", true));
    for (;;)
    {
      paramIntent = (Uri)paramIntent;
      if (paramIntent != null) {
        break;
      }
      Log.i("MicroMsg.Nfc.DeepLinkNfcProcessor", "process, not deep link uri");
      AppMethodBeat.o(261806);
      return false;
      paramIntent = null;
    }
    boolean bool = com.tencent.mm.plugin.expt.model.a.dMQ().a(c.a.yQx, true);
    Log.i("MicroMsg.Nfc.DeepLinkNfcProcessor", s.X("process, isNfcDeepLinkEnable: ", Boolean.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(261806);
      return true;
    }
    Log.i("MicroMsg.Nfc.DeepLinkNfcProcessor", s.X("process, uri: ", paramIntent));
    paramIntent = new Intent("android.intent.action.VIEW", paramIntent);
    paramIntent.setClass(paramContext, WXCustomSchemeEntryActivity.class);
    paramIntent.putExtra("translate_link_scene", 21);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/nfc_open/logic/DeepLinkNfcProcessor", "process", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/nfc_open/logic/DeepLinkNfcProcessor", "process", "(Landroid/content/Context;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(261806);
    return true;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final int getPriority()
  {
    return this.priority;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.a.b
 * JD-Core Version:    0.7.0.1
 */