package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fwr
  extends com.tencent.mm.bx.a
{
  public String OzQ;
  public int YIc;
  public String aamF;
  public String aant;
  public String abUp;
  public int abUq;
  public String abUr;
  public String abUs;
  public int abUt;
  public String abUu;
  public int abUv;
  public gol abUw;
  public gol abUx;
  public String abwa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152723);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.OzQ != null) {
        paramVarArgs.g(1, this.OzQ);
      }
      if (this.abUp != null) {
        paramVarArgs.g(2, this.abUp);
      }
      if (this.aant != null) {
        paramVarArgs.g(3, this.aant);
      }
      paramVarArgs.bS(4, this.abUq);
      if (this.abwa != null) {
        paramVarArgs.g(5, this.abwa);
      }
      if (this.abUr != null) {
        paramVarArgs.g(6, this.abUr);
      }
      if (this.abUs != null) {
        paramVarArgs.g(7, this.abUs);
      }
      paramVarArgs.bS(8, this.abUt);
      if (this.abUu != null) {
        paramVarArgs.g(9, this.abUu);
      }
      paramVarArgs.bS(10, this.abUv);
      if (this.abUw != null)
      {
        paramVarArgs.qD(11, this.abUw.computeSize());
        this.abUw.writeFields(paramVarArgs);
      }
      if (this.aamF != null) {
        paramVarArgs.g(12, this.aamF);
      }
      paramVarArgs.bS(13, this.YIc);
      if (this.abUx != null)
      {
        paramVarArgs.qD(14, this.abUx.computeSize());
        this.abUx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152723);
      return 0;
    }
    if (paramInt == 1) {
      if (this.OzQ == null) {
        break label1090;
      }
    }
    label1090:
    for (int i = i.a.a.b.b.a.h(1, this.OzQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abUp != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abUp);
      }
      i = paramInt;
      if (this.aant != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aant);
      }
      i += i.a.a.b.b.a.cJ(4, this.abUq);
      paramInt = i;
      if (this.abwa != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abwa);
      }
      i = paramInt;
      if (this.abUr != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abUr);
      }
      paramInt = i;
      if (this.abUs != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abUs);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.abUt);
      paramInt = i;
      if (this.abUu != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abUu);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.abUv);
      paramInt = i;
      if (this.abUw != null) {
        paramInt = i + i.a.a.a.qC(11, this.abUw.computeSize());
      }
      i = paramInt;
      if (this.aamF != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.aamF);
      }
      i += i.a.a.b.b.a.cJ(13, this.YIc);
      paramInt = i;
      if (this.abUx != null) {
        paramInt = i + i.a.a.a.qC(14, this.abUx.computeSize());
      }
      AppMethodBeat.o(152723);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152723);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fwr localfwr = (fwr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        gol localgol;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152723);
          return -1;
        case 1: 
          localfwr.OzQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 2: 
          localfwr.abUp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 3: 
          localfwr.aant = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 4: 
          localfwr.abUq = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152723);
          return 0;
        case 5: 
          localfwr.abwa = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 6: 
          localfwr.abUr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 7: 
          localfwr.abUs = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 8: 
          localfwr.abUt = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152723);
          return 0;
        case 9: 
          localfwr.abUu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 10: 
          localfwr.abUv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152723);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localgol = new gol();
            if ((localObject != null) && (localObject.length > 0)) {
              localgol.dg((byte[])localObject);
            }
            localfwr.abUw = localgol;
            paramInt += 1;
          }
          AppMethodBeat.o(152723);
          return 0;
        case 12: 
          localfwr.aamF = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 13: 
          localfwr.YIc = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152723);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localfwr.abUx = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(152723);
        return 0;
      }
      AppMethodBeat.o(152723);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fwr
 * JD-Core Version:    0.7.0.1
 */