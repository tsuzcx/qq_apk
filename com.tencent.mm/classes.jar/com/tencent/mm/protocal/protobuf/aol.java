package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aol
  extends cvw
{
  public alw GDR;
  public int GFQ;
  public b rPQ;
  public int rRE;
  public int scene;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168988);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GFQ);
      if (this.rPQ != null) {
        paramVarArgs.c(3, this.rPQ);
      }
      if (this.username != null) {
        paramVarArgs.d(4, this.username);
      }
      paramVarArgs.aS(5, this.scene);
      if (this.GDR != null)
      {
        paramVarArgs.lJ(6, this.GDR.computeSize());
        this.GDR.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.rRE);
      AppMethodBeat.o(168988);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GFQ);
      paramInt = i;
      if (this.rPQ != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.rPQ);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.username);
      }
      i += f.a.a.b.b.a.bz(5, this.scene);
      paramInt = i;
      if (this.GDR != null) {
        paramInt = i + f.a.a.a.lI(6, this.GDR.computeSize());
      }
      i = f.a.a.b.b.a.bz(7, this.rRE);
      AppMethodBeat.o(168988);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168988);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aol localaol = (aol)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168988);
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
            localaol.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168988);
          return 0;
        case 2: 
          localaol.GFQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168988);
          return 0;
        case 3: 
          localaol.rPQ = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(168988);
          return 0;
        case 4: 
          localaol.username = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168988);
          return 0;
        case 5: 
          localaol.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168988);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaol.GDR = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168988);
          return 0;
        }
        localaol.rRE = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(168988);
        return 0;
      }
      AppMethodBeat.o(168988);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aol
 * JD-Core Version:    0.7.0.1
 */