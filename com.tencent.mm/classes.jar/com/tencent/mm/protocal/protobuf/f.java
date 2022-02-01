package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class f
  extends cvw
{
  public String FIf;
  public int FIh;
  public long FIi;
  public LinkedList<String> FIj;
  public bb FIk;
  public long FIl;
  public String FIm;
  public String FIn;
  public String FIo;
  public int scene;
  public String title;
  
  public f()
  {
    AppMethodBeat.i(91315);
    this.FIj = new LinkedList();
    AppMethodBeat.o(91315);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91316);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FIh);
      paramVarArgs.aZ(3, this.FIi);
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      paramVarArgs.e(5, 1, this.FIj);
      paramVarArgs.aS(6, this.scene);
      if (this.FIf != null) {
        paramVarArgs.d(7, this.FIf);
      }
      if (this.FIk != null)
      {
        paramVarArgs.lJ(8, this.FIk.computeSize());
        this.FIk.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(9, this.FIl);
      if (this.FIm != null) {
        paramVarArgs.d(10, this.FIm);
      }
      if (this.FIn != null) {
        paramVarArgs.d(11, this.FIn);
      }
      if (this.FIo != null) {
        paramVarArgs.d(12, this.FIo);
      }
      AppMethodBeat.o(91316);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1010;
      }
    }
    label1010:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FIh) + f.a.a.b.b.a.p(3, this.FIi);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.title);
      }
      i = paramInt + f.a.a.a.c(5, 1, this.FIj) + f.a.a.b.b.a.bz(6, this.scene);
      paramInt = i;
      if (this.FIf != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FIf);
      }
      i = paramInt;
      if (this.FIk != null) {
        i = paramInt + f.a.a.a.lI(8, this.FIk.computeSize());
      }
      i += f.a.a.b.b.a.p(9, this.FIl);
      paramInt = i;
      if (this.FIm != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FIm);
      }
      i = paramInt;
      if (this.FIn != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.FIn);
      }
      paramInt = i;
      if (this.FIo != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FIo);
      }
      AppMethodBeat.o(91316);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FIj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91316);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91316);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91316);
          return 0;
        case 2: 
          localf.FIh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91316);
          return 0;
        case 3: 
          localf.FIi = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91316);
          return 0;
        case 4: 
          localf.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 5: 
          localf.FIj.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(91316);
          return 0;
        case 6: 
          localf.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91316);
          return 0;
        case 7: 
          localf.FIf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.FIk = ((bb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91316);
          return 0;
        case 9: 
          localf.FIl = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91316);
          return 0;
        case 10: 
          localf.FIm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 11: 
          localf.FIn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91316);
          return 0;
        }
        localf.FIo = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91316);
        return 0;
      }
      AppMethodBeat.o(91316);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.f
 * JD-Core Version:    0.7.0.1
 */