package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class erq
  extends erp
{
  public String OcL;
  public String OcM;
  public int Ocy;
  public String YIM;
  public int YXw;
  public String abdU;
  public int abvk;
  public String abvl;
  public int abvm;
  public int abvn;
  public b abvo;
  public String hAk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72581);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.OcL != null) {
        paramVarArgs.g(2, this.OcL);
      }
      if (this.OcM != null) {
        paramVarArgs.g(3, this.OcM);
      }
      if (this.hAk != null) {
        paramVarArgs.g(4, this.hAk);
      }
      paramVarArgs.bS(5, this.Ocy);
      paramVarArgs.bS(6, this.abvk);
      if (this.abvl != null) {
        paramVarArgs.g(7, this.abvl);
      }
      paramVarArgs.bS(8, this.abvm);
      paramVarArgs.bS(9, this.abvn);
      if (this.YIM != null) {
        paramVarArgs.g(10, this.YIM);
      }
      if (this.abdU != null) {
        paramVarArgs.g(11, this.abdU);
      }
      if (this.abvo != null) {
        paramVarArgs.d(12, this.abvo);
      }
      paramVarArgs.bS(13, this.YXw);
      AppMethodBeat.o(72581);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label936;
      }
    }
    label936:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.OcL != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.OcL);
      }
      i = paramInt;
      if (this.OcM != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.OcM);
      }
      paramInt = i;
      if (this.hAk != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.hAk);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.Ocy) + i.a.a.b.b.a.cJ(6, this.abvk);
      paramInt = i;
      if (this.abvl != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abvl);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.abvm) + i.a.a.b.b.a.cJ(9, this.abvn);
      paramInt = i;
      if (this.YIM != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.YIM);
      }
      i = paramInt;
      if (this.abdU != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.abdU);
      }
      paramInt = i;
      if (this.abvo != null) {
        paramInt = i + i.a.a.b.b.a.c(12, this.abvo);
      }
      i = i.a.a.b.b.a.cJ(13, this.YXw);
      AppMethodBeat.o(72581);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72581);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        erq localerq = (erq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72581);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localerq.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(72581);
          return 0;
        case 2: 
          localerq.OcL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 3: 
          localerq.OcM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 4: 
          localerq.hAk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 5: 
          localerq.Ocy = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72581);
          return 0;
        case 6: 
          localerq.abvk = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72581);
          return 0;
        case 7: 
          localerq.abvl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 8: 
          localerq.abvm = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72581);
          return 0;
        case 9: 
          localerq.abvn = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72581);
          return 0;
        case 10: 
          localerq.YIM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 11: 
          localerq.abdU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 12: 
          localerq.abvo = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(72581);
          return 0;
        }
        localerq.YXw = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(72581);
        return 0;
      }
      AppMethodBeat.o(72581);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erq
 * JD-Core Version:    0.7.0.1
 */