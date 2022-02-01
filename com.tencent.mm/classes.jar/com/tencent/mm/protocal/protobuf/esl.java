package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class esl
  extends erp
{
  public int CreateTime;
  public String IMg;
  public String IMh;
  public String YHk;
  public int abwb;
  public int abwc;
  public int abwd;
  public long abwe;
  public String abwf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32415);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YHk != null) {
        paramVarArgs.g(2, this.YHk);
      }
      paramVarArgs.bS(3, this.abwb);
      paramVarArgs.bS(4, this.CreateTime);
      paramVarArgs.bS(5, this.abwc);
      if (this.IMh != null) {
        paramVarArgs.g(6, this.IMh);
      }
      if (this.IMg != null) {
        paramVarArgs.g(7, this.IMg);
      }
      paramVarArgs.bS(8, this.abwd);
      paramVarArgs.bv(9, this.abwe);
      if (this.abwf != null) {
        paramVarArgs.g(10, this.abwf);
      }
      AppMethodBeat.o(32415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label764;
      }
    }
    label764:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YHk != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YHk);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.abwb) + i.a.a.b.b.a.cJ(4, this.CreateTime) + i.a.a.b.b.a.cJ(5, this.abwc);
      paramInt = i;
      if (this.IMh != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.IMh);
      }
      i = paramInt;
      if (this.IMg != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.IMg);
      }
      i = i + i.a.a.b.b.a.cJ(8, this.abwd) + i.a.a.b.b.a.q(9, this.abwe);
      paramInt = i;
      if (this.abwf != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.abwf);
      }
      AppMethodBeat.o(32415);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32415);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        esl localesl = (esl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32415);
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
            localesl.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32415);
          return 0;
        case 2: 
          localesl.YHk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 3: 
          localesl.abwb = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32415);
          return 0;
        case 4: 
          localesl.CreateTime = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32415);
          return 0;
        case 5: 
          localesl.abwc = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32415);
          return 0;
        case 6: 
          localesl.IMh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 7: 
          localesl.IMg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 8: 
          localesl.abwd = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32415);
          return 0;
        case 9: 
          localesl.abwe = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(32415);
          return 0;
        }
        localesl.abwf = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32415);
        return 0;
      }
      AppMethodBeat.o(32415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esl
 * JD-Core Version:    0.7.0.1
 */