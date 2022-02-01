package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cxa
  extends esc
{
  public gjx ZiP;
  public LinkedList<gll> aaCA;
  public gll aaCB;
  public String aaCC;
  public int aaCD;
  public String aaCE;
  public String aaCF;
  public String aaCG;
  public String aaCH;
  public int aaCn;
  
  public cxa()
  {
    AppMethodBeat.i(123594);
    this.aaCA = new LinkedList();
    AppMethodBeat.o(123594);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123595);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123595);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZiP != null)
      {
        paramVarArgs.qD(2, this.ZiP.computeSize());
        this.ZiP.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.aaCA);
      if (this.aaCB != null)
      {
        paramVarArgs.qD(4, this.aaCB.computeSize());
        this.aaCB.writeFields(paramVarArgs);
      }
      if (this.aaCC != null) {
        paramVarArgs.g(5, this.aaCC);
      }
      paramVarArgs.bS(6, this.aaCD);
      if (this.aaCE != null) {
        paramVarArgs.g(7, this.aaCE);
      }
      if (this.aaCF != null) {
        paramVarArgs.g(8, this.aaCF);
      }
      if (this.aaCG != null) {
        paramVarArgs.g(9, this.aaCG);
      }
      if (this.aaCH != null) {
        paramVarArgs.g(10, this.aaCH);
      }
      paramVarArgs.bS(11, this.aaCn);
      AppMethodBeat.o(123595);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1118;
      }
    }
    label1118:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZiP != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZiP.computeSize());
      }
      i += i.a.a.a.c(3, 8, this.aaCA);
      paramInt = i;
      if (this.aaCB != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaCB.computeSize());
      }
      i = paramInt;
      if (this.aaCC != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaCC);
      }
      i += i.a.a.b.b.a.cJ(6, this.aaCD);
      paramInt = i;
      if (this.aaCE != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aaCE);
      }
      i = paramInt;
      if (this.aaCF != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.aaCF);
      }
      paramInt = i;
      if (this.aaCG != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.aaCG);
      }
      i = paramInt;
      if (this.aaCH != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.aaCH);
      }
      paramInt = i.a.a.b.b.a.cJ(11, this.aaCn);
      AppMethodBeat.o(123595);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaCA.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123595);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123595);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cxa localcxa = (cxa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123595);
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
            localcxa.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gjx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gjx)localObject2).parseFrom((byte[])localObject1);
            }
            localcxa.ZiP = ((gjx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gll();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gll)localObject2).parseFrom((byte[])localObject1);
            }
            localcxa.aaCA.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gll();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gll)localObject2).parseFrom((byte[])localObject1);
            }
            localcxa.aaCB = ((gll)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 5: 
          localcxa.aaCC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 6: 
          localcxa.aaCD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123595);
          return 0;
        case 7: 
          localcxa.aaCE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 8: 
          localcxa.aaCF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 9: 
          localcxa.aaCG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 10: 
          localcxa.aaCH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123595);
          return 0;
        }
        localcxa.aaCn = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(123595);
        return 0;
      }
      AppMethodBeat.o(123595);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxa
 * JD-Core Version:    0.7.0.1
 */