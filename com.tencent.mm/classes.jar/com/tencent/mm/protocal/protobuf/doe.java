package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class doe
  extends dop
{
  public long MKf;
  public long MRu;
  public String MRv;
  public int MRw;
  public int MRx;
  public int MRy;
  public long MRz;
  public int Mnc;
  public int Scene;
  public String jfi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117902);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.MRu);
      if (this.MRv != null) {
        paramVarArgs.e(3, this.MRv);
      }
      paramVarArgs.aM(4, this.Scene);
      paramVarArgs.aM(5, this.MRw);
      paramVarArgs.aM(6, this.Mnc);
      paramVarArgs.aM(7, this.MRx);
      paramVarArgs.bb(8, this.MKf);
      paramVarArgs.aM(9, this.MRy);
      if (this.jfi != null) {
        paramVarArgs.e(10, this.jfi);
      }
      paramVarArgs.bb(11, this.MRz);
      AppMethodBeat.o(117902);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.MRu);
      paramInt = i;
      if (this.MRv != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.MRv);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.Scene) + g.a.a.b.b.a.bu(5, this.MRw) + g.a.a.b.b.a.bu(6, this.Mnc) + g.a.a.b.b.a.bu(7, this.MRx) + g.a.a.b.b.a.r(8, this.MKf) + g.a.a.b.b.a.bu(9, this.MRy);
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.jfi);
      }
      i = g.a.a.b.b.a.r(11, this.MRz);
      AppMethodBeat.o(117902);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117902);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        doe localdoe = (doe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117902);
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
            localdoe.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117902);
          return 0;
        case 2: 
          localdoe.MRu = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(117902);
          return 0;
        case 3: 
          localdoe.MRv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117902);
          return 0;
        case 4: 
          localdoe.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117902);
          return 0;
        case 5: 
          localdoe.MRw = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117902);
          return 0;
        case 6: 
          localdoe.Mnc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117902);
          return 0;
        case 7: 
          localdoe.MRx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117902);
          return 0;
        case 8: 
          localdoe.MKf = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(117902);
          return 0;
        case 9: 
          localdoe.MRy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117902);
          return 0;
        case 10: 
          localdoe.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117902);
          return 0;
        }
        localdoe.MRz = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(117902);
        return 0;
      }
      AppMethodBeat.o(117902);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doe
 * JD-Core Version:    0.7.0.1
 */