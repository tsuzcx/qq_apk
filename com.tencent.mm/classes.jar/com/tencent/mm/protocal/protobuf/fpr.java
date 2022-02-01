package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fpr
  extends esc
{
  public String DUR;
  public int OfA;
  public String Ofy;
  public String Ofz;
  public int Okq;
  public String abPA;
  public String abPB;
  public String abPC;
  public epk abPn;
  public String abPo;
  public String abPp;
  public String abPq;
  public epk abPy;
  public LinkedList<aje> abPz;
  public String wsM;
  public String wuA;
  public int wuz;
  
  public fpr()
  {
    AppMethodBeat.i(72598);
    this.abPz = new LinkedList();
    AppMethodBeat.o(72598);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72599);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      paramVarArgs.bS(4, this.OfA);
      if (this.abPy != null)
      {
        paramVarArgs.qD(5, this.abPy.computeSize());
        this.abPy.writeFields(paramVarArgs);
      }
      if (this.abPo != null) {
        paramVarArgs.g(6, this.abPo);
      }
      if (this.abPp != null) {
        paramVarArgs.g(7, this.abPp);
      }
      if (this.Ofy != null) {
        paramVarArgs.g(8, this.Ofy);
      }
      if (this.Ofz != null) {
        paramVarArgs.g(9, this.Ofz);
      }
      if (this.wsM != null) {
        paramVarArgs.g(10, this.wsM);
      }
      if (this.DUR != null) {
        paramVarArgs.g(11, this.DUR);
      }
      paramVarArgs.bS(12, this.Okq);
      paramVarArgs.e(13, 8, this.abPz);
      if (this.abPA != null) {
        paramVarArgs.g(14, this.abPA);
      }
      if (this.abPB != null) {
        paramVarArgs.g(15, this.abPB);
      }
      if (this.abPq != null) {
        paramVarArgs.g(16, this.abPq);
      }
      if (this.abPC != null) {
        paramVarArgs.g(17, this.abPC);
      }
      if (this.abPn != null)
      {
        paramVarArgs.qD(18, this.abPn.computeSize());
        this.abPn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72599);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1486;
      }
    }
    label1486:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.OfA);
      paramInt = i;
      if (this.abPy != null) {
        paramInt = i + i.a.a.a.qC(5, this.abPy.computeSize());
      }
      i = paramInt;
      if (this.abPo != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abPo);
      }
      paramInt = i;
      if (this.abPp != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abPp);
      }
      i = paramInt;
      if (this.Ofy != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.Ofy);
      }
      paramInt = i;
      if (this.Ofz != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Ofz);
      }
      i = paramInt;
      if (this.wsM != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.wsM);
      }
      paramInt = i;
      if (this.DUR != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.DUR);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.Okq) + i.a.a.a.c(13, 8, this.abPz);
      paramInt = i;
      if (this.abPA != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.abPA);
      }
      i = paramInt;
      if (this.abPB != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.abPB);
      }
      paramInt = i;
      if (this.abPq != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.abPq);
      }
      i = paramInt;
      if (this.abPC != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.abPC);
      }
      paramInt = i;
      if (this.abPn != null) {
        paramInt = i + i.a.a.a.qC(18, this.abPn.computeSize());
      }
      AppMethodBeat.o(72599);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abPz.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72599);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fpr localfpr = (fpr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72599);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localfpr.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 2: 
          localfpr.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72599);
          return 0;
        case 3: 
          localfpr.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 4: 
          localfpr.OfA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72599);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epk)localObject2).parseFrom((byte[])localObject1);
            }
            localfpr.abPy = ((epk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 6: 
          localfpr.abPo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 7: 
          localfpr.abPp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 8: 
          localfpr.Ofy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 9: 
          localfpr.Ofz = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 10: 
          localfpr.wsM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 11: 
          localfpr.DUR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 12: 
          localfpr.Okq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72599);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aje();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aje)localObject2).parseFrom((byte[])localObject1);
            }
            localfpr.abPz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 14: 
          localfpr.abPA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 15: 
          localfpr.abPB = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 16: 
          localfpr.abPq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 17: 
          localfpr.abPC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72599);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new epk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((epk)localObject2).parseFrom((byte[])localObject1);
          }
          localfpr.abPn = ((epk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72599);
        return 0;
      }
      AppMethodBeat.o(72599);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpr
 * JD-Core Version:    0.7.0.1
 */