package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class foa
  extends com.tencent.mm.bx.a
{
  public int TpP;
  public int abNU;
  public String abNV;
  public fnz abNW;
  public int endTime;
  public boolean hBY;
  public String id;
  public String sbU;
  public int type;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258182);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "beginTime", Integer.valueOf(this.TpP), false);
      com.tencent.mm.bk.a.a(localJSONObject, "endTime", Integer.valueOf(this.endTime), false);
      com.tencent.mm.bk.a.a(localJSONObject, "minShowTime", Integer.valueOf(this.abNU), false);
      com.tencent.mm.bk.a.a(localJSONObject, "type", Integer.valueOf(this.type), false);
      com.tencent.mm.bk.a.a(localJSONObject, "id", this.id, false);
      com.tencent.mm.bk.a.a(localJSONObject, "subId", this.sbU, false);
      com.tencent.mm.bk.a.a(localJSONObject, "bizUin", this.abNV, false);
      com.tencent.mm.bk.a.a(localJSONObject, "videoDotInfo", this.abNW, false);
      com.tencent.mm.bk.a.a(localJSONObject, "isShow", Boolean.valueOf(this.hBY), false);
      label127:
      AppMethodBeat.o(258182);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label127;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153001);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.TpP);
      paramVarArgs.bS(2, this.endTime);
      paramVarArgs.bS(3, this.abNU);
      paramVarArgs.bS(4, this.type);
      if (this.id != null) {
        paramVarArgs.g(5, this.id);
      }
      if (this.sbU != null) {
        paramVarArgs.g(6, this.sbU);
      }
      if (this.abNV != null) {
        paramVarArgs.g(7, this.abNV);
      }
      if (this.abNW != null)
      {
        paramVarArgs.qD(8, this.abNW.computeSize());
        this.abNW.writeFields(paramVarArgs);
      }
      paramVarArgs.di(9, this.hBY);
      AppMethodBeat.o(153001);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.TpP) + 0 + i.a.a.b.b.a.cJ(2, this.endTime) + i.a.a.b.b.a.cJ(3, this.abNU) + i.a.a.b.b.a.cJ(4, this.type);
      paramInt = i;
      if (this.id != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.id);
      }
      i = paramInt;
      if (this.sbU != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.sbU);
      }
      paramInt = i;
      if (this.abNV != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abNV);
      }
      i = paramInt;
      if (this.abNW != null) {
        i = paramInt + i.a.a.a.qC(8, this.abNW.computeSize());
      }
      paramInt = i.a.a.b.b.a.ko(9);
      AppMethodBeat.o(153001);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(153001);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      foa localfoa = (foa)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153001);
        return -1;
      case 1: 
        localfoa.TpP = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(153001);
        return 0;
      case 2: 
        localfoa.endTime = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(153001);
        return 0;
      case 3: 
        localfoa.abNU = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(153001);
        return 0;
      case 4: 
        localfoa.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(153001);
        return 0;
      case 5: 
        localfoa.id = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 6: 
        localfoa.sbU = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 7: 
        localfoa.abNV = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fnz localfnz = new fnz();
          if ((localObject != null) && (localObject.length > 0)) {
            localfnz.parseFrom((byte[])localObject);
          }
          localfoa.abNW = localfnz;
          paramInt += 1;
        }
        AppMethodBeat.o(153001);
        return 0;
      }
      localfoa.hBY = ((i.a.a.a.a)localObject).ajGk.aai();
      AppMethodBeat.o(153001);
      return 0;
    }
    AppMethodBeat.o(153001);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.foa
 * JD-Core Version:    0.7.0.1
 */