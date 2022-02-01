package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ctm
  extends dop
{
  public b LXC;
  public int Myo;
  public int Myp;
  public b Myq;
  public int Myr;
  public String Mys;
  public String Myt;
  public String Myu;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(120957);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.Myo);
      paramVarArgs.aM(3, this.Myp);
      if (this.Myq != null) {
        paramVarArgs.c(4, this.Myq);
      }
      paramVarArgs.aM(5, this.Myr);
      if (this.LXC != null) {
        paramVarArgs.c(6, this.LXC);
      }
      if (this.Mys != null) {
        paramVarArgs.e(7, this.Mys);
      }
      if (this.Myt != null) {
        paramVarArgs.e(8, this.Myt);
      }
      if (this.Myu != null) {
        paramVarArgs.e(9, this.Myu);
      }
      paramVarArgs.aM(10, this.Scene);
      AppMethodBeat.o(120957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label794;
      }
    }
    label794:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.Myo) + g.a.a.b.b.a.bu(3, this.Myp);
      paramInt = i;
      if (this.Myq != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.Myq);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.Myr);
      paramInt = i;
      if (this.LXC != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.LXC);
      }
      i = paramInt;
      if (this.Mys != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Mys);
      }
      paramInt = i;
      if (this.Myt != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Myt);
      }
      i = paramInt;
      if (this.Myu != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Myu);
      }
      paramInt = g.a.a.b.b.a.bu(10, this.Scene);
      AppMethodBeat.o(120957);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(120957);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ctm localctm = (ctm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(120957);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctm.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(120957);
          return 0;
        case 2: 
          localctm.Myo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(120957);
          return 0;
        case 3: 
          localctm.Myp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(120957);
          return 0;
        case 4: 
          localctm.Myq = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(120957);
          return 0;
        case 5: 
          localctm.Myr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(120957);
          return 0;
        case 6: 
          localctm.LXC = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(120957);
          return 0;
        case 7: 
          localctm.Mys = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(120957);
          return 0;
        case 8: 
          localctm.Myt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(120957);
          return 0;
        case 9: 
          localctm.Myu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(120957);
          return 0;
        }
        localctm.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(120957);
        return 0;
      }
      AppMethodBeat.o(120957);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctm
 * JD-Core Version:    0.7.0.1
 */