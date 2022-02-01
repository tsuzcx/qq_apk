package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bhw
  extends com.tencent.mm.bx.a
{
  public String CFx;
  public cmf DFJ;
  public int DFK;
  public String Dap;
  public String mAQ;
  public int oXh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155423);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DFJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(155423);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.oXh);
      if (this.DFJ != null)
      {
        paramVarArgs.kX(2, this.DFJ.computeSize());
        this.DFJ.writeFields(paramVarArgs);
      }
      if (this.CFx != null) {
        paramVarArgs.d(3, this.CFx);
      }
      if (this.Dap != null) {
        paramVarArgs.d(4, this.Dap);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(5, this.mAQ);
      }
      paramVarArgs.aR(6, this.DFK);
      AppMethodBeat.o(155423);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.oXh) + 0;
      paramInt = i;
      if (this.DFJ != null) {
        paramInt = i + f.a.a.a.kW(2, this.DFJ.computeSize());
      }
      i = paramInt;
      if (this.CFx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CFx);
      }
      paramInt = i;
      if (this.Dap != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dap);
      }
      i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.mAQ);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.DFK);
      AppMethodBeat.o(155423);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.DFJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(155423);
        throw paramVarArgs;
      }
      AppMethodBeat.o(155423);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bhw localbhw = (bhw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155423);
        return -1;
      case 1: 
        localbhw.oXh = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(155423);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbhw.DFJ = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155423);
        return 0;
      case 3: 
        localbhw.CFx = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155423);
        return 0;
      case 4: 
        localbhw.Dap = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155423);
        return 0;
      case 5: 
        localbhw.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155423);
        return 0;
      }
      localbhw.DFK = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(155423);
      return 0;
    }
    AppMethodBeat.o(155423);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhw
 * JD-Core Version:    0.7.0.1
 */