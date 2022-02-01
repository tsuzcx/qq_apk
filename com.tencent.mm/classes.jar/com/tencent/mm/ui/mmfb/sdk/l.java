package com.tencent.mm.ui.mmfb.sdk;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public final class l
{
  private static String afAf;
  private static final String afAg;
  private static final String afAh;
  private static final String afAi;
  private static final String afAj;
  private static final List<Integer> afAk;
  
  static
  {
    AppMethodBeat.i(250191);
    afAf = "com.facebook.platform.protocol.";
    afAg = afAf + "PROTOCOL_VERSION";
    afAh = afAf + "CALL_ID";
    afAi = afAf + "BRIDGE_ARGS";
    afAj = afAf + "RESULT_ARGS";
    afAk = Arrays.asList(new Integer[] { Integer.valueOf(20170417), Integer.valueOf(20160327), Integer.valueOf(20141218), Integer.valueOf(20141107), Integer.valueOf(20141028), Integer.valueOf(20141001), Integer.valueOf(20140701), Integer.valueOf(20140324), Integer.valueOf(20140204), Integer.valueOf(20131107), Integer.valueOf(20130618), Integer.valueOf(20130502), Integer.valueOf(20121101) });
    AppMethodBeat.o(250191);
  }
  
  private static int cn(Intent paramIntent)
  {
    AppMethodBeat.i(250180);
    int i = paramIntent.getIntExtra(afAg, 0);
    AppMethodBeat.o(250180);
    return i;
  }
  
  private static UUID co(Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(250185);
    if (paramIntent == null)
    {
      AppMethodBeat.o(250185);
      return null;
    }
    int i = cn(paramIntent);
    if ((afAk.contains(Integer.valueOf(i))) && (i >= 20140701))
    {
      i = 1;
      if (i == 0) {
        break label92;
      }
      paramIntent = paramIntent.getBundleExtra(afAi);
      if (paramIntent == null) {
        break label109;
      }
    }
    label92:
    label109:
    for (paramIntent = paramIntent.getString("action_id");; paramIntent = null) {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (paramIntent != null) {}
        try
        {
          localObject1 = UUID.fromString(paramIntent);
          AppMethodBeat.o(250185);
          return localObject1;
          i = 0;
          break;
          paramIntent = paramIntent.getStringExtra(afAh);
        }
        catch (IllegalArgumentException paramIntent)
        {
          for (;;)
          {
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  public static Intent d(Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(250174);
    UUID localUUID = co(paramIntent);
    if (localUUID == null)
    {
      AppMethodBeat.o(250174);
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra(afAg, cn(paramIntent));
    paramIntent = new Bundle();
    paramIntent.putString("action_id", localUUID.toString());
    localIntent.putExtra(afAi, paramIntent);
    if (paramBundle != null) {
      localIntent.putExtra(afAj, paramBundle);
    }
    AppMethodBeat.o(250174);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.mmfb.sdk.l
 * JD-Core Version:    0.7.0.1
 */