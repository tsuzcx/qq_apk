package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class aeg
  extends com.tencent.mm.bx.a
{
  public String Zmj;
  public aec Zmk;
  public String comment;
  public String hOG;
  public long timestamp;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257456);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "timestamp", Long.valueOf(this.timestamp), false);
      com.tencent.mm.bk.a.a(localJSONObject, "objectBuffer", this.Zmj, false);
      com.tencent.mm.bk.a.a(localJSONObject, "comment", this.comment, false);
      com.tencent.mm.bk.a.a(localJSONObject, "requestId", this.hOG, false);
      com.tencent.mm.bk.a.a(localJSONObject, "appInfo", this.Zmk, false);
      label71:
      AppMethodBeat.o(257456);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label71;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117861);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.timestamp);
      if (this.Zmj != null) {
        paramVarArgs.g(2, this.Zmj);
      }
      if (this.comment != null) {
        paramVarArgs.g(3, this.comment);
      }
      if (this.hOG != null) {
        paramVarArgs.g(4, this.hOG);
      }
      if (this.Zmk != null)
      {
        paramVarArgs.qD(5, this.Zmk.computeSize());
        this.Zmk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117861);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.timestamp) + 0;
      paramInt = i;
      if (this.Zmj != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zmj);
      }
      i = paramInt;
      if (this.comment != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.comment);
      }
      paramInt = i;
      if (this.hOG != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.hOG);
      }
      i = paramInt;
      if (this.Zmk != null) {
        i = paramInt + i.a.a.a.qC(5, this.Zmk.computeSize());
      }
      AppMethodBeat.o(117861);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117861);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      aeg localaeg = (aeg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117861);
        return -1;
      case 1: 
        localaeg.timestamp = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(117861);
        return 0;
      case 2: 
        localaeg.Zmj = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(117861);
        return 0;
      case 3: 
        localaeg.comment = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(117861);
        return 0;
      case 4: 
        localaeg.hOG = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(117861);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        aec localaec = new aec();
        if ((localObject != null) && (localObject.length > 0)) {
          localaec.parseFrom((byte[])localObject);
        }
        localaeg.Zmk = localaec;
        paramInt += 1;
      }
      AppMethodBeat.o(117861);
      return 0;
    }
    AppMethodBeat.o(117861);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aeg
 * JD-Core Version:    0.7.0.1
 */