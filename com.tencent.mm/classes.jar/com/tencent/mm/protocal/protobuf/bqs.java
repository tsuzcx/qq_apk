package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bqs
  extends com.tencent.mm.bw.a
{
  public String FVO;
  public String Gtk;
  public cxn Hed;
  public int Hee;
  public String nIJ;
  public int qkC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155423);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hed == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(155423);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.qkC);
      if (this.Hed != null)
      {
        paramVarArgs.lJ(2, this.Hed.computeSize());
        this.Hed.writeFields(paramVarArgs);
      }
      if (this.FVO != null) {
        paramVarArgs.d(3, this.FVO);
      }
      if (this.Gtk != null) {
        paramVarArgs.d(4, this.Gtk);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(5, this.nIJ);
      }
      paramVarArgs.aS(6, this.Hee);
      AppMethodBeat.o(155423);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.qkC) + 0;
      paramInt = i;
      if (this.Hed != null) {
        paramInt = i + f.a.a.a.lI(2, this.Hed.computeSize());
      }
      i = paramInt;
      if (this.FVO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FVO);
      }
      paramInt = i;
      if (this.Gtk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gtk);
      }
      i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nIJ);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.Hee);
      AppMethodBeat.o(155423);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.Hed == null)
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
      bqs localbqs = (bqs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155423);
        return -1;
      case 1: 
        localbqs.qkC = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(155423);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbqs.Hed = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155423);
        return 0;
      case 3: 
        localbqs.FVO = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155423);
        return 0;
      case 4: 
        localbqs.Gtk = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155423);
        return 0;
      case 5: 
        localbqs.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155423);
        return 0;
      }
      localbqs.Hee = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(155423);
      return 0;
    }
    AppMethodBeat.o(155423);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqs
 * JD-Core Version:    0.7.0.1
 */