package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ask
  extends cvw
{
  public alw GDR;
  public LinkedList<FinderContact> GGk;
  public LinkedList<FinderContact> GHZ;
  public SKBuiltinBuffer_t GJB;
  public LinkedList<arj> LGu;
  public String LGv;
  public int dvk;
  public String sbR;
  public int scene;
  
  public ask()
  {
    AppMethodBeat.i(169060);
    this.GGk = new LinkedList();
    this.GHZ = new LinkedList();
    this.LGu = new LinkedList();
    AppMethodBeat.o(169060);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169061);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dvk);
      if (this.GJB != null)
      {
        paramVarArgs.lJ(3, this.GJB.computeSize());
        this.GJB.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.GGk);
      paramVarArgs.e(5, 8, this.GHZ);
      if (this.sbR != null) {
        paramVarArgs.d(6, this.sbR);
      }
      if (this.GDR != null)
      {
        paramVarArgs.lJ(7, this.GDR.computeSize());
        this.GDR.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.scene);
      paramVarArgs.e(9, 8, this.LGu);
      if (this.LGv != null) {
        paramVarArgs.d(10, this.LGv);
      }
      AppMethodBeat.o(169061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1250;
      }
    }
    label1250:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dvk);
      paramInt = i;
      if (this.GJB != null) {
        paramInt = i + f.a.a.a.lI(3, this.GJB.computeSize());
      }
      i = paramInt + f.a.a.a.c(4, 8, this.GGk) + f.a.a.a.c(5, 8, this.GHZ);
      paramInt = i;
      if (this.sbR != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sbR);
      }
      i = paramInt;
      if (this.GDR != null) {
        i = paramInt + f.a.a.a.lI(7, this.GDR.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(8, this.scene) + f.a.a.a.c(9, 8, this.LGu);
      paramInt = i;
      if (this.LGv != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.LGv);
      }
      AppMethodBeat.o(169061);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GGk.clear();
        this.GHZ.clear();
        this.LGu.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169061);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ask localask = (ask)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169061);
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
            localask.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 2: 
          localask.dvk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169061);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localask.GJB = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localask.GGk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localask.GHZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 6: 
          localask.sbR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169061);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localask.GDR = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 8: 
          localask.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169061);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new arj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((arj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localask.LGu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        }
        localask.LGv = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169061);
        return 0;
      }
      AppMethodBeat.o(169061);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ask
 * JD-Core Version:    0.7.0.1
 */