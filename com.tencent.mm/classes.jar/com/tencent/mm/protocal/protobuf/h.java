package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends cvw
{
  public String FIf;
  public LinkedList<j> FIj;
  public bb FIk;
  public long FIl;
  public String FIm;
  public String FIn;
  public String FIo;
  public long FIr;
  public int scene;
  public String title;
  
  public h()
  {
    AppMethodBeat.i(91318);
    this.FIj = new LinkedList();
    AppMethodBeat.o(91318);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91319);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      paramVarArgs.aZ(3, this.FIr);
      paramVarArgs.e(5, 8, this.FIj);
      paramVarArgs.aS(7, this.scene);
      if (this.FIf != null) {
        paramVarArgs.d(8, this.FIf);
      }
      if (this.FIk != null)
      {
        paramVarArgs.lJ(9, this.FIk.computeSize());
        this.FIk.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(10, this.FIl);
      if (this.FIm != null) {
        paramVarArgs.d(11, this.FIm);
      }
      if (this.FIn != null) {
        paramVarArgs.d(12, this.FIn);
      }
      if (this.FIo != null) {
        paramVarArgs.d(13, this.FIo);
      }
      AppMethodBeat.o(91319);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1054;
      }
    }
    label1054:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.title);
      }
      i = i + f.a.a.b.b.a.p(3, this.FIr) + f.a.a.a.c(5, 8, this.FIj) + f.a.a.b.b.a.bz(7, this.scene);
      paramInt = i;
      if (this.FIf != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FIf);
      }
      i = paramInt;
      if (this.FIk != null) {
        i = paramInt + f.a.a.a.lI(9, this.FIk.computeSize());
      }
      i += f.a.a.b.b.a.p(10, this.FIl);
      paramInt = i;
      if (this.FIm != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FIm);
      }
      i = paramInt;
      if (this.FIn != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FIn);
      }
      paramInt = i;
      if (this.FIo != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FIo);
      }
      AppMethodBeat.o(91319);
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
        AppMethodBeat.o(91319);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 4: 
        case 6: 
        default: 
          AppMethodBeat.o(91319);
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
            localh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 2: 
          localh.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 3: 
          localh.FIr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91319);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new j();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localh.FIj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 7: 
          localh.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91319);
          return 0;
        case 8: 
          localh.FIf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localh.FIk = ((bb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 10: 
          localh.FIl = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91319);
          return 0;
        case 11: 
          localh.FIm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 12: 
          localh.FIn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91319);
          return 0;
        }
        localh.FIo = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91319);
        return 0;
      }
      AppMethodBeat.o(91319);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.h
 * JD-Core Version:    0.7.0.1
 */