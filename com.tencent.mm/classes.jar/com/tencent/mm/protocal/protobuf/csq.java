package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csq
  extends com.tencent.mm.bw.a
{
  public long KTS;
  public long LQL;
  public long LQM;
  public String MqU;
  public String MqW;
  public LinkedList<String> MqX;
  public LinkedList<clq> MqY;
  public String MxH;
  
  public csq()
  {
    AppMethodBeat.i(110907);
    this.MqX = new LinkedList();
    this.MqY = new LinkedList();
    AppMethodBeat.o(110907);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110908);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.LQM);
      paramVarArgs.bb(2, this.LQL);
      if (this.MqU != null) {
        paramVarArgs.e(3, this.MqU);
      }
      paramVarArgs.bb(4, this.KTS);
      if (this.MqW != null) {
        paramVarArgs.e(5, this.MqW);
      }
      paramVarArgs.e(6, 1, this.MqX);
      paramVarArgs.e(7, 8, this.MqY);
      if (this.MxH != null) {
        paramVarArgs.e(8, this.MxH);
      }
      AppMethodBeat.o(110908);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.LQM) + 0 + g.a.a.b.b.a.r(2, this.LQL);
      paramInt = i;
      if (this.MqU != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.MqU);
      }
      i = paramInt + g.a.a.b.b.a.r(4, this.KTS);
      paramInt = i;
      if (this.MqW != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MqW);
      }
      i = paramInt + g.a.a.a.c(6, 1, this.MqX) + g.a.a.a.c(7, 8, this.MqY);
      paramInt = i;
      if (this.MxH != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.MxH);
      }
      AppMethodBeat.o(110908);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MqX.clear();
      this.MqY.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(110908);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      csq localcsq = (csq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110908);
        return -1;
      case 1: 
        localcsq.LQM = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110908);
        return 0;
      case 2: 
        localcsq.LQL = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110908);
        return 0;
      case 3: 
        localcsq.MqU = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(110908);
        return 0;
      case 4: 
        localcsq.KTS = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110908);
        return 0;
      case 5: 
        localcsq.MqW = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(110908);
        return 0;
      case 6: 
        localcsq.MqX.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(110908);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new clq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((clq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcsq.MqY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110908);
        return 0;
      }
      localcsq.MxH = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(110908);
      return 0;
    }
    AppMethodBeat.o(110908);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csq
 * JD-Core Version:    0.7.0.1
 */