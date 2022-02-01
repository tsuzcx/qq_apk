package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqt
  extends cvw
{
  public bqz HXI;
  public LinkedList<du> HXJ;
  public String link;
  public int scene;
  
  public dqt()
  {
    AppMethodBeat.i(152712);
    this.HXJ = new LinkedList();
    AppMethodBeat.o(152712);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152713);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.link != null) {
        paramVarArgs.d(2, this.link);
      }
      paramVarArgs.aS(3, this.scene);
      if (this.HXI != null)
      {
        paramVarArgs.lJ(4, this.HXI.computeSize());
        this.HXI.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.HXJ);
      AppMethodBeat.o(152713);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label710;
      }
    }
    label710:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.link != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.link);
      }
      i += f.a.a.b.b.a.bz(3, this.scene);
      paramInt = i;
      if (this.HXI != null) {
        paramInt = i + f.a.a.a.lI(4, this.HXI.computeSize());
      }
      i = f.a.a.a.c(5, 8, this.HXJ);
      AppMethodBeat.o(152713);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HXJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152713);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqt localdqt = (dqt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152713);
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
            localdqt.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152713);
          return 0;
        case 2: 
          localdqt.link = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152713);
          return 0;
        case 3: 
          localdqt.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152713);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqt.HXI = ((bqz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152713);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new du();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((du)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqt.HXJ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152713);
        return 0;
      }
      AppMethodBeat.o(152713);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqt
 * JD-Core Version:    0.7.0.1
 */