package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class sy
  extends com.tencent.mm.bx.a
{
  public LinkedList<tf> IIU;
  public long YYo;
  public int YYp;
  public LinkedList<String> YYq;
  public String YYr;
  public int YYs;
  public String hAP;
  public int vhm;
  
  public sy()
  {
    AppMethodBeat.i(117842);
    this.YYq = new LinkedList();
    this.IIU = new LinkedList();
    AppMethodBeat.o(117842);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260044);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BusinessType", Long.valueOf(this.YYo), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ContinueFlag", Integer.valueOf(this.YYp), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Title", this.hAP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "KeyWordList", this.YYq, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ItemList", this.IIU, false);
      com.tencent.mm.bk.a.a(localJSONObject, "TotalCount", Integer.valueOf(this.vhm), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SearchID", this.YYr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Offset", Integer.valueOf(this.YYs), false);
      label113:
      AppMethodBeat.o(260044);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label113;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117843);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YYr == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchID");
        AppMethodBeat.o(117843);
        throw paramVarArgs;
      }
      paramVarArgs.bv(1, this.YYo);
      paramVarArgs.bS(2, this.YYp);
      if (this.hAP != null) {
        paramVarArgs.g(3, this.hAP);
      }
      paramVarArgs.e(4, 1, this.YYq);
      paramVarArgs.e(5, 8, this.IIU);
      paramVarArgs.bS(6, this.vhm);
      if (this.YYr != null) {
        paramVarArgs.g(7, this.YYr);
      }
      paramVarArgs.bS(8, this.YYs);
      AppMethodBeat.o(117843);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.YYo) + 0 + i.a.a.b.b.a.cJ(2, this.YYp);
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.hAP);
      }
      i = paramInt + i.a.a.a.c(4, 1, this.YYq) + i.a.a.a.c(5, 8, this.IIU) + i.a.a.b.b.a.cJ(6, this.vhm);
      paramInt = i;
      if (this.YYr != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YYr);
      }
      i = i.a.a.b.b.a.cJ(8, this.YYs);
      AppMethodBeat.o(117843);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YYq.clear();
      this.IIU.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.YYr == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchID");
        AppMethodBeat.o(117843);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117843);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      sy localsy = (sy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117843);
        return -1;
      case 1: 
        localsy.YYo = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(117843);
        return 0;
      case 2: 
        localsy.YYp = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(117843);
        return 0;
      case 3: 
        localsy.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(117843);
        return 0;
      case 4: 
        localsy.YYq.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(117843);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          tf localtf = new tf();
          if ((localObject != null) && (localObject.length > 0)) {
            localtf.parseFrom((byte[])localObject);
          }
          localsy.IIU.add(localtf);
          paramInt += 1;
        }
        AppMethodBeat.o(117843);
        return 0;
      case 6: 
        localsy.vhm = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(117843);
        return 0;
      case 7: 
        localsy.YYr = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(117843);
        return 0;
      }
      localsy.YYs = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(117843);
      return 0;
    }
    AppMethodBeat.o(117843);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sy
 * JD-Core Version:    0.7.0.1
 */