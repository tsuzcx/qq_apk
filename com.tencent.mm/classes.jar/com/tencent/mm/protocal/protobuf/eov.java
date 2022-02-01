package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eov
  extends erp
{
  public int IJG;
  public gol YOj;
  public String aaoV;
  public long aaoY;
  public String absZ;
  public String abta;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104375);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.aaoY);
      if (this.absZ != null) {
        paramVarArgs.g(3, this.absZ);
      }
      if (this.abta != null) {
        paramVarArgs.g(4, this.abta);
      }
      if (this.aaoV != null) {
        paramVarArgs.g(5, this.aaoV);
      }
      if (this.YOj != null)
      {
        paramVarArgs.qD(6, this.YOj.computeSize());
        this.YOj.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.IJG);
      AppMethodBeat.o(104375);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.aaoY);
      paramInt = i;
      if (this.absZ != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.absZ);
      }
      i = paramInt;
      if (this.abta != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abta);
      }
      paramInt = i;
      if (this.aaoV != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaoV);
      }
      i = paramInt;
      if (this.YOj != null) {
        i = paramInt + i.a.a.a.qC(6, this.YOj.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(7, this.IJG);
      AppMethodBeat.o(104375);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104375);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eov localeov = (eov)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104375);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localeov.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104375);
          return 0;
        case 2: 
          localeov.aaoY = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(104375);
          return 0;
        case 3: 
          localeov.absZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104375);
          return 0;
        case 4: 
          localeov.abta = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104375);
          return 0;
        case 5: 
          localeov.aaoV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104375);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localeov.YOj = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104375);
          return 0;
        }
        localeov.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(104375);
        return 0;
      }
      AppMethodBeat.o(104375);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eov
 * JD-Core Version:    0.7.0.1
 */