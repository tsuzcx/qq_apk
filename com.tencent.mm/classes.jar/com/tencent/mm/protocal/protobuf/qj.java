package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c;
import f.a.a.b;
import java.util.LinkedList;

public final class qj
  extends cwj
{
  public c DqV;
  public long DqX;
  public LinkedList<String> GeA;
  public int GeB;
  public int GeC;
  public String GeD;
  public String GeE;
  public String GeF;
  public boolean GeG;
  public long Gez;
  public int oGt;
  public String oGu;
  
  public qj()
  {
    AppMethodBeat.i(91377);
    this.GeA = new LinkedList();
    AppMethodBeat.o(91377);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91378);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91378);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      paramVarArgs.aZ(4, this.DqX);
      if (this.DqV != null)
      {
        paramVarArgs.lJ(5, this.DqV.computeSize());
        this.DqV.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(6, this.Gez);
      paramVarArgs.e(7, 1, this.GeA);
      paramVarArgs.aS(8, this.GeB);
      paramVarArgs.aS(9, this.GeC);
      if (this.GeD != null) {
        paramVarArgs.d(10, this.GeD);
      }
      if (this.GeE != null) {
        paramVarArgs.d(11, this.GeE);
      }
      if (this.GeF != null) {
        paramVarArgs.d(12, this.GeF);
      }
      paramVarArgs.bC(13, this.GeG);
      AppMethodBeat.o(91378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1082;
      }
    }
    label1082:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt + f.a.a.b.b.a.p(4, this.DqX);
      paramInt = i;
      if (this.DqV != null) {
        paramInt = i + f.a.a.a.lI(5, this.DqV.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.Gez) + f.a.a.a.c(7, 1, this.GeA) + f.a.a.b.b.a.bz(8, this.GeB) + f.a.a.b.b.a.bz(9, this.GeC);
      paramInt = i;
      if (this.GeD != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GeD);
      }
      i = paramInt;
      if (this.GeE != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.GeE);
      }
      paramInt = i;
      if (this.GeF != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GeF);
      }
      i = f.a.a.b.b.a.amF(13);
      AppMethodBeat.o(91378);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GeA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91378);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qj localqj = (qj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91378);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91378);
          return 0;
        case 2: 
          localqj.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91378);
          return 0;
        case 3: 
          localqj.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 4: 
          localqj.DqX = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91378);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqj.DqV = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91378);
          return 0;
        case 6: 
          localqj.Gez = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91378);
          return 0;
        case 7: 
          localqj.GeA.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(91378);
          return 0;
        case 8: 
          localqj.GeB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91378);
          return 0;
        case 9: 
          localqj.GeC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91378);
          return 0;
        case 10: 
          localqj.GeD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 11: 
          localqj.GeE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 12: 
          localqj.GeF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91378);
          return 0;
        }
        localqj.GeG = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(91378);
        return 0;
      }
      AppMethodBeat.o(91378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qj
 * JD-Core Version:    0.7.0.1
 */