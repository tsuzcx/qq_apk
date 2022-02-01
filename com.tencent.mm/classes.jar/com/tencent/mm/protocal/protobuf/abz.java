package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abz
  extends com.tencent.mm.bw.a
{
  public String Leo;
  public String Lep;
  public long LfD;
  public String LfE;
  public String LfF;
  public bzq LmB;
  public String pRY;
  public String pRZ;
  public String qGB;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113985);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.pRY != null) {
        paramVarArgs.e(2, this.pRY);
      }
      if (this.pRZ != null) {
        paramVarArgs.e(3, this.pRZ);
      }
      if (this.url != null) {
        paramVarArgs.e(4, this.url);
      }
      paramVarArgs.bb(5, this.LfD);
      if (this.LfE != null) {
        paramVarArgs.e(6, this.LfE);
      }
      if (this.LfF != null) {
        paramVarArgs.e(7, this.LfF);
      }
      if (this.qGB != null) {
        paramVarArgs.e(8, this.qGB);
      }
      if (this.LmB != null)
      {
        paramVarArgs.ni(9, this.LmB.computeSize());
        this.LmB.writeFields(paramVarArgs);
      }
      if (this.Leo != null) {
        paramVarArgs.e(10, this.Leo);
      }
      if (this.Lep != null) {
        paramVarArgs.e(11, this.Lep);
      }
      AppMethodBeat.o(113985);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label906;
      }
    }
    label906:
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pRY != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.pRY);
      }
      i = paramInt;
      if (this.pRZ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.pRZ);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.url);
      }
      i = paramInt + g.a.a.b.b.a.r(5, this.LfD);
      paramInt = i;
      if (this.LfE != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LfE);
      }
      i = paramInt;
      if (this.LfF != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.LfF);
      }
      paramInt = i;
      if (this.qGB != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.qGB);
      }
      i = paramInt;
      if (this.LmB != null) {
        i = paramInt + g.a.a.a.nh(9, this.LmB.computeSize());
      }
      paramInt = i;
      if (this.Leo != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.Leo);
      }
      i = paramInt;
      if (this.Lep != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.Lep);
      }
      AppMethodBeat.o(113985);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(113985);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        abz localabz = (abz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113985);
          return -1;
        case 1: 
          localabz.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 2: 
          localabz.pRY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 3: 
          localabz.pRZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 4: 
          localabz.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 5: 
          localabz.LfD = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(113985);
          return 0;
        case 6: 
          localabz.LfE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 7: 
          localabz.LfF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 8: 
          localabz.qGB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bzq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localabz.LmB = ((bzq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113985);
          return 0;
        case 10: 
          localabz.Leo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113985);
          return 0;
        }
        localabz.Lep = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(113985);
        return 0;
      }
      AppMethodBeat.o(113985);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abz
 * JD-Core Version:    0.7.0.1
 */