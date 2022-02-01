package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class exr
  extends erp
{
  public int IJG;
  public String YHk;
  public String abnl;
  public String abzq;
  public String abzr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259360);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abnl != null) {
        paramVarArgs.g(2, this.abnl);
      }
      if (this.abzq != null) {
        paramVarArgs.g(3, this.abzq);
      }
      if (this.abzr != null) {
        paramVarArgs.g(4, this.abzr);
      }
      if (this.YHk != null) {
        paramVarArgs.g(5, this.YHk);
      }
      paramVarArgs.bS(6, this.IJG);
      AppMethodBeat.o(259360);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label572;
      }
    }
    label572:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abnl != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abnl);
      }
      i = paramInt;
      if (this.abzq != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abzq);
      }
      paramInt = i;
      if (this.abzr != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abzr);
      }
      i = paramInt;
      if (this.YHk != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YHk);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.IJG);
      AppMethodBeat.o(259360);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259360);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        exr localexr = (exr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259360);
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
            localexr.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259360);
          return 0;
        case 2: 
          localexr.abnl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259360);
          return 0;
        case 3: 
          localexr.abzq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259360);
          return 0;
        case 4: 
          localexr.abzr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259360);
          return 0;
        case 5: 
          localexr.YHk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259360);
          return 0;
        }
        localexr.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259360);
        return 0;
      }
      AppMethodBeat.o(259360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exr
 * JD-Core Version:    0.7.0.1
 */