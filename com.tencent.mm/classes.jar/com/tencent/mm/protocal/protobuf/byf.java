package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class byf
  extends dpc
{
  public String Desc;
  public String MdG;
  public String MdH;
  public String MdI;
  public String MdJ;
  public String MdK;
  public String MdL;
  public ewp MdM;
  public String MdN;
  public String MdO;
  public String MdP;
  public String MdQ;
  public String MdR;
  public int Mdq;
  public LinkedList<ewj> Mdr;
  public String Title;
  public String xJH;
  
  public byf()
  {
    AppMethodBeat.i(32308);
    this.Mdr = new LinkedList();
    AppMethodBeat.o(32308);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32309);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32309);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.MdG != null) {
        paramVarArgs.e(2, this.MdG);
      }
      if (this.xJH != null) {
        paramVarArgs.e(3, this.xJH);
      }
      if (this.Title != null) {
        paramVarArgs.e(4, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(5, this.Desc);
      }
      if (this.MdH != null) {
        paramVarArgs.e(6, this.MdH);
      }
      if (this.MdI != null) {
        paramVarArgs.e(7, this.MdI);
      }
      if (this.MdJ != null) {
        paramVarArgs.e(8, this.MdJ);
      }
      if (this.MdK != null) {
        paramVarArgs.e(9, this.MdK);
      }
      if (this.MdL != null) {
        paramVarArgs.e(10, this.MdL);
      }
      if (this.MdM != null)
      {
        paramVarArgs.ni(11, this.MdM.computeSize());
        this.MdM.writeFields(paramVarArgs);
      }
      if (this.MdN != null) {
        paramVarArgs.e(12, this.MdN);
      }
      if (this.MdO != null) {
        paramVarArgs.e(13, this.MdO);
      }
      if (this.MdP != null) {
        paramVarArgs.e(14, this.MdP);
      }
      if (this.MdQ != null) {
        paramVarArgs.e(15, this.MdQ);
      }
      if (this.MdR != null) {
        paramVarArgs.e(16, this.MdR);
      }
      paramVarArgs.aM(17, this.Mdq);
      paramVarArgs.e(18, 8, this.Mdr);
      AppMethodBeat.o(32309);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1590;
      }
    }
    label1590:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MdG != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MdG);
      }
      i = paramInt;
      if (this.xJH != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xJH);
      }
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Title);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Desc);
      }
      paramInt = i;
      if (this.MdH != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MdH);
      }
      i = paramInt;
      if (this.MdI != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MdI);
      }
      paramInt = i;
      if (this.MdJ != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.MdJ);
      }
      i = paramInt;
      if (this.MdK != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.MdK);
      }
      paramInt = i;
      if (this.MdL != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.MdL);
      }
      i = paramInt;
      if (this.MdM != null) {
        i = paramInt + g.a.a.a.nh(11, this.MdM.computeSize());
      }
      paramInt = i;
      if (this.MdN != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.MdN);
      }
      i = paramInt;
      if (this.MdO != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.MdO);
      }
      paramInt = i;
      if (this.MdP != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.MdP);
      }
      i = paramInt;
      if (this.MdQ != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.MdQ);
      }
      paramInt = i;
      if (this.MdR != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.MdR);
      }
      i = g.a.a.b.b.a.bu(17, this.Mdq);
      int j = g.a.a.a.c(18, 8, this.Mdr);
      AppMethodBeat.o(32309);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mdr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32309);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32309);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        byf localbyf = (byf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32309);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbyf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32309);
          return 0;
        case 2: 
          localbyf.MdG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 3: 
          localbyf.xJH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 4: 
          localbyf.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 5: 
          localbyf.Desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 6: 
          localbyf.MdH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 7: 
          localbyf.MdI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 8: 
          localbyf.MdJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 9: 
          localbyf.MdK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 10: 
          localbyf.MdL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ewp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ewp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbyf.MdM = ((ewp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32309);
          return 0;
        case 12: 
          localbyf.MdN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 13: 
          localbyf.MdO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 14: 
          localbyf.MdP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 15: 
          localbyf.MdQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 16: 
          localbyf.MdR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 17: 
          localbyf.Mdq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32309);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ewj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ewj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbyf.Mdr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32309);
        return 0;
      }
      AppMethodBeat.o(32309);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byf
 * JD-Core Version:    0.7.0.1
 */