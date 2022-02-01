package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class evn
  extends com.tencent.mm.bx.a
{
  public LinkedList<evo> Idy;
  public String abyo;
  public int abyp;
  public String abyq;
  public String abyr;
  public int abys;
  public String hAP;
  public String vhX;
  
  public evn()
  {
    AppMethodBeat.i(260233);
    this.Idy = new LinkedList();
    AppMethodBeat.o(260233);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260234);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Title", this.hAP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Tid", this.abyo, false);
      com.tencent.mm.bk.a.a(localJSONObject, "FeedType", Integer.valueOf(this.abyp), false);
      com.tencent.mm.bk.a.a(localJSONObject, "NickName", this.vhX, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Avatar", this.abyq, false);
      com.tencent.mm.bk.a.a(localJSONObject, "NonceID", this.abyr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "MediaCount", Integer.valueOf(this.abys), false);
      com.tencent.mm.bk.a.a(localJSONObject, "MediaList", this.Idy, false);
      label107:
      AppMethodBeat.o(260234);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label107;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260239);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.abyo != null) {
        paramVarArgs.g(2, this.abyo);
      }
      paramVarArgs.bS(3, this.abyp);
      if (this.vhX != null) {
        paramVarArgs.g(4, this.vhX);
      }
      if (this.abyq != null) {
        paramVarArgs.g(5, this.abyq);
      }
      if (this.abyr != null) {
        paramVarArgs.g(6, this.abyr);
      }
      paramVarArgs.bS(7, this.abys);
      paramVarArgs.e(8, 8, this.Idy);
      AppMethodBeat.o(260239);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label668;
      }
    }
    label668:
    for (paramInt = i.a.a.b.b.a.h(1, this.hAP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abyo != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abyo);
      }
      i += i.a.a.b.b.a.cJ(3, this.abyp);
      paramInt = i;
      if (this.vhX != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.vhX);
      }
      i = paramInt;
      if (this.abyq != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abyq);
      }
      paramInt = i;
      if (this.abyr != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abyr);
      }
      i = i.a.a.b.b.a.cJ(7, this.abys);
      int j = i.a.a.a.c(8, 8, this.Idy);
      AppMethodBeat.o(260239);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Idy.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260239);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        evn localevn = (evn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260239);
          return -1;
        case 1: 
          localevn.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(260239);
          return 0;
        case 2: 
          localevn.abyo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(260239);
          return 0;
        case 3: 
          localevn.abyp = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(260239);
          return 0;
        case 4: 
          localevn.vhX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(260239);
          return 0;
        case 5: 
          localevn.abyq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(260239);
          return 0;
        case 6: 
          localevn.abyr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(260239);
          return 0;
        case 7: 
          localevn.abys = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(260239);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          evo localevo = new evo();
          if ((localObject != null) && (localObject.length > 0)) {
            localevo.parseFrom((byte[])localObject);
          }
          localevn.Idy.add(localevo);
          paramInt += 1;
        }
        AppMethodBeat.o(260239);
        return 0;
      }
      AppMethodBeat.o(260239);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evn
 * JD-Core Version:    0.7.0.1
 */