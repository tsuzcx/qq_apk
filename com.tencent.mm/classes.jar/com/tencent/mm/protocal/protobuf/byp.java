package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byp
  extends ckq
{
  public az CPi;
  public String CXk;
  public String CXl;
  public String CXm;
  public String CXn;
  public String DVt;
  public String DVu;
  public String DVv;
  public String DVw;
  public String DVx;
  public String DoP;
  public String hnC;
  public String rZy;
  public String scR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91571);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hnC != null) {
        paramVarArgs.d(2, this.hnC);
      }
      if (this.DVt != null) {
        paramVarArgs.d(3, this.DVt);
      }
      if (this.DoP != null) {
        paramVarArgs.d(4, this.DoP);
      }
      if (this.CXk != null) {
        paramVarArgs.d(5, this.CXk);
      }
      if (this.DVu != null) {
        paramVarArgs.d(6, this.DVu);
      }
      if (this.CXl != null) {
        paramVarArgs.d(7, this.CXl);
      }
      if (this.CXm != null) {
        paramVarArgs.d(8, this.CXm);
      }
      if (this.CXn != null) {
        paramVarArgs.d(9, this.CXn);
      }
      if (this.DVv != null) {
        paramVarArgs.d(10, this.DVv);
      }
      if (this.CPi != null)
      {
        paramVarArgs.kX(11, this.CPi.computeSize());
        this.CPi.writeFields(paramVarArgs);
      }
      if (this.DVw != null) {
        paramVarArgs.d(12, this.DVw);
      }
      if (this.rZy != null) {
        paramVarArgs.d(13, this.rZy);
      }
      if (this.scR != null) {
        paramVarArgs.d(14, this.scR);
      }
      if (this.DVx != null) {
        paramVarArgs.d(15, this.DVx);
      }
      AppMethodBeat.o(91571);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1266;
      }
    }
    label1266:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hnC);
      }
      i = paramInt;
      if (this.DVt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DVt);
      }
      paramInt = i;
      if (this.DoP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DoP);
      }
      i = paramInt;
      if (this.CXk != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CXk);
      }
      paramInt = i;
      if (this.DVu != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DVu);
      }
      i = paramInt;
      if (this.CXl != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CXl);
      }
      paramInt = i;
      if (this.CXm != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CXm);
      }
      i = paramInt;
      if (this.CXn != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CXn);
      }
      paramInt = i;
      if (this.DVv != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DVv);
      }
      i = paramInt;
      if (this.CPi != null) {
        i = paramInt + f.a.a.a.kW(11, this.CPi.computeSize());
      }
      paramInt = i;
      if (this.DVw != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DVw);
      }
      i = paramInt;
      if (this.rZy != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.rZy);
      }
      paramInt = i;
      if (this.scR != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.scR);
      }
      i = paramInt;
      if (this.DVx != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.DVx);
      }
      AppMethodBeat.o(91571);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91571);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        byp localbyp = (byp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91571);
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
            localbyp.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91571);
          return 0;
        case 2: 
          localbyp.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 3: 
          localbyp.DVt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 4: 
          localbyp.DoP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 5: 
          localbyp.CXk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 6: 
          localbyp.DVu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 7: 
          localbyp.CXl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 8: 
          localbyp.CXm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 9: 
          localbyp.CXn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 10: 
          localbyp.DVv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new az();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((az)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyp.CPi = ((az)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91571);
          return 0;
        case 12: 
          localbyp.DVw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 13: 
          localbyp.rZy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 14: 
          localbyp.scR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91571);
          return 0;
        }
        localbyp.DVx = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91571);
        return 0;
      }
      AppMethodBeat.o(91571);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byp
 * JD-Core Version:    0.7.0.1
 */