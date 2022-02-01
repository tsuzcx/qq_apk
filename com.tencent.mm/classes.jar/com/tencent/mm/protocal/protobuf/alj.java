package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alj
  extends cld
{
  public int DmB;
  public int DmC;
  public int DmD;
  public akp DmE;
  public dyi Lyq;
  public int Lyr;
  public LinkedList<FinderObject> Lys;
  public dzx Lyt;
  public dyf Lyu;
  public com.tencent.mm.bx.b lastBuffer;
  public LinkedList<FinderObject> object;
  public String qyp;
  public String qyq;
  public int qyr;
  
  public alj()
  {
    AppMethodBeat.i(169057);
    this.object = new LinkedList();
    this.Lys = new LinkedList();
    AppMethodBeat.o(169057);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169058);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(169058);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      if (this.qyp != null) {
        paramVarArgs.d(4, this.qyp);
      }
      if (this.qyq != null) {
        paramVarArgs.d(5, this.qyq);
      }
      paramVarArgs.aR(6, this.qyr);
      paramVarArgs.aR(7, this.DmB);
      paramVarArgs.aR(8, this.DmC);
      paramVarArgs.aR(9, this.DmD);
      if (this.DmE != null)
      {
        paramVarArgs.kX(10, this.DmE.computeSize());
        this.DmE.writeFields(paramVarArgs);
      }
      if (this.Lyq != null)
      {
        paramVarArgs.kX(11, this.Lyq.computeSize());
        this.Lyq.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(12, this.Lyr);
      paramVarArgs.e(13, 8, this.Lys);
      if (this.Lyt != null)
      {
        paramVarArgs.kX(14, this.Lyt.computeSize());
        this.Lyt.writeFields(paramVarArgs);
      }
      if (this.Lyu != null)
      {
        paramVarArgs.kX(15, this.Lyu.computeSize());
        this.Lyu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169058);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1666;
      }
    }
    label1666:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt;
      if (this.qyp != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.qyp);
      }
      paramInt = i;
      if (this.qyq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.qyq);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.qyr) + f.a.a.b.b.a.bA(7, this.DmB) + f.a.a.b.b.a.bA(8, this.DmC) + f.a.a.b.b.a.bA(9, this.DmD);
      paramInt = i;
      if (this.DmE != null) {
        paramInt = i + f.a.a.a.kW(10, this.DmE.computeSize());
      }
      i = paramInt;
      if (this.Lyq != null) {
        i = paramInt + f.a.a.a.kW(11, this.Lyq.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(12, this.Lyr) + f.a.a.a.c(13, 8, this.Lys);
      paramInt = i;
      if (this.Lyt != null) {
        paramInt = i + f.a.a.a.kW(14, this.Lyt.computeSize());
      }
      i = paramInt;
      if (this.Lyu != null) {
        i = paramInt + f.a.a.a.kW(15, this.Lyu.computeSize());
      }
      AppMethodBeat.o(169058);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.Lys.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(169058);
          throw paramVarArgs;
        }
        AppMethodBeat.o(169058);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        alj localalj = (alj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169058);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalj.object.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 3: 
          localalj.lastBuffer = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(169058);
          return 0;
        case 4: 
          localalj.qyp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 5: 
          localalj.qyq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 6: 
          localalj.qyr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169058);
          return 0;
        case 7: 
          localalj.DmB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169058);
          return 0;
        case 8: 
          localalj.DmC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169058);
          return 0;
        case 9: 
          localalj.DmD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169058);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalj.DmE = ((akp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalj.Lyq = ((dyi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 12: 
          localalj.Lyr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169058);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalj.Lys.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalj.Lyt = ((dzx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dyf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dyf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalj.Lyu = ((dyf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169058);
        return 0;
      }
      AppMethodBeat.o(169058);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alj
 * JD-Core Version:    0.7.0.1
 */