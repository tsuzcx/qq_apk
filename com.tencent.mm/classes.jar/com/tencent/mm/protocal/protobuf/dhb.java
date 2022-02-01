package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhb
  extends ckq
{
  public String EhK;
  public int Exj;
  public int Exk;
  public String Exl;
  public int Exm;
  public String Exn;
  public LinkedList<cxa> Exo;
  public int Exp;
  public int Exq;
  public int bUc;
  public String cLR;
  public String dfF;
  public String gIw;
  
  public dhb()
  {
    AppMethodBeat.i(116818);
    this.Exo = new LinkedList();
    AppMethodBeat.o(116818);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116819);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.cLR != null) {
        paramVarArgs.d(2, this.cLR);
      }
      if (this.dfF != null) {
        paramVarArgs.d(3, this.dfF);
      }
      paramVarArgs.aR(4, this.Exj);
      paramVarArgs.aR(5, this.Exk);
      paramVarArgs.aR(6, this.bUc);
      if (this.Exl != null) {
        paramVarArgs.d(7, this.Exl);
      }
      if (this.EhK != null) {
        paramVarArgs.d(8, this.EhK);
      }
      if (this.gIw != null) {
        paramVarArgs.d(9, this.gIw);
      }
      paramVarArgs.aR(10, this.Exm);
      if (this.Exn != null) {
        paramVarArgs.d(11, this.Exn);
      }
      paramVarArgs.e(12, 8, this.Exo);
      paramVarArgs.aR(13, this.Exp);
      paramVarArgs.aR(14, this.Exq);
      AppMethodBeat.o(116819);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1094;
      }
    }
    label1094:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cLR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.cLR);
      }
      i = paramInt;
      if (this.dfF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dfF);
      }
      i = i + f.a.a.b.b.a.bA(4, this.Exj) + f.a.a.b.b.a.bA(5, this.Exk) + f.a.a.b.b.a.bA(6, this.bUc);
      paramInt = i;
      if (this.Exl != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Exl);
      }
      i = paramInt;
      if (this.EhK != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EhK);
      }
      paramInt = i;
      if (this.gIw != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.gIw);
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.Exm);
      paramInt = i;
      if (this.Exn != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Exn);
      }
      i = f.a.a.a.c(12, 8, this.Exo);
      int j = f.a.a.b.b.a.bA(13, this.Exp);
      int k = f.a.a.b.b.a.bA(14, this.Exq);
      AppMethodBeat.o(116819);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Exo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(116819);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhb localdhb = (dhb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116819);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhb.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116819);
          return 0;
        case 2: 
          localdhb.cLR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 3: 
          localdhb.dfF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 4: 
          localdhb.Exj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(116819);
          return 0;
        case 5: 
          localdhb.Exk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(116819);
          return 0;
        case 6: 
          localdhb.bUc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(116819);
          return 0;
        case 7: 
          localdhb.Exl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 8: 
          localdhb.EhK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 9: 
          localdhb.gIw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 10: 
          localdhb.Exm = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(116819);
          return 0;
        case 11: 
          localdhb.Exn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhb.Exo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116819);
          return 0;
        case 13: 
          localdhb.Exp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(116819);
          return 0;
        }
        localdhb.Exq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(116819);
        return 0;
      }
      AppMethodBeat.o(116819);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhb
 * JD-Core Version:    0.7.0.1
 */