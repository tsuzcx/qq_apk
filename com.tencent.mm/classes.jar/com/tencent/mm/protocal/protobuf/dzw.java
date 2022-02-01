package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dzw
  extends com.tencent.mm.bw.a
{
  public int Cst;
  public ctw IeZ;
  public afe Ifa;
  public int Ifb;
  public LinkedList<Integer> Ifc;
  public int Ifd;
  public LinkedList<Integer> Ife;
  public ctw Iff;
  
  public dzw()
  {
    AppMethodBeat.i(115897);
    this.Ifc = new LinkedList();
    this.Ife = new LinkedList();
    AppMethodBeat.o(115897);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115898);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IeZ != null)
      {
        paramVarArgs.lJ(1, this.IeZ.computeSize());
        this.IeZ.writeFields(paramVarArgs);
      }
      if (this.Ifa != null)
      {
        paramVarArgs.lJ(2, this.Ifa.computeSize());
        this.Ifa.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.Ifb);
      paramVarArgs.f(4, 2, this.Ifc);
      paramVarArgs.aS(5, this.Ifd);
      paramVarArgs.f(6, 2, this.Ife);
      paramVarArgs.aS(7, this.Cst);
      if (this.Iff != null)
      {
        paramVarArgs.lJ(8, this.Iff.computeSize());
        this.Iff.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115898);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IeZ == null) {
        break label896;
      }
    }
    label896:
    for (paramInt = f.a.a.a.lI(1, this.IeZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ifa != null) {
        i = paramInt + f.a.a.a.lI(2, this.Ifa.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(3, this.Ifb) + f.a.a.a.d(4, 2, this.Ifc) + f.a.a.b.b.a.bz(5, this.Ifd) + f.a.a.a.d(6, 2, this.Ife) + f.a.a.b.b.a.bz(7, this.Cst);
      paramInt = i;
      if (this.Iff != null) {
        paramInt = i + f.a.a.a.lI(8, this.Iff.computeSize());
      }
      AppMethodBeat.o(115898);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ifc.clear();
        this.Ife.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(115898);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzw localdzw = (dzw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115898);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzw.IeZ = ((ctw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115898);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzw.Ifa = ((afe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115898);
          return 0;
        case 3: 
          localdzw.Ifb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115898);
          return 0;
        case 4: 
          localdzw.Ifc = new f.a.a.a.a(((f.a.a.a.a)localObject1).OmT.gCk().zr, unknownTagHandler).OmT.gCi();
          AppMethodBeat.o(115898);
          return 0;
        case 5: 
          localdzw.Ifd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115898);
          return 0;
        case 6: 
          localdzw.Ife = new f.a.a.a.a(((f.a.a.a.a)localObject1).OmT.gCk().zr, unknownTagHandler).OmT.gCi();
          AppMethodBeat.o(115898);
          return 0;
        case 7: 
          localdzw.Cst = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115898);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ctw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ctw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdzw.Iff = ((ctw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115898);
        return 0;
      }
      AppMethodBeat.o(115898);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzw
 * JD-Core Version:    0.7.0.1
 */