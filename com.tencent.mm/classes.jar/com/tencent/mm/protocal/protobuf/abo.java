package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class abo
  extends esc
{
  public int Tqb;
  public com.tencent.mm.bx.b Zkg;
  public com.tencent.mm.bx.b Zkh;
  public com.tencent.mm.bx.b Zki;
  public com.tencent.mm.bx.b Zkj;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258407);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258407);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Zkg != null) {
        paramVarArgs.d(2, this.Zkg);
      }
      if (this.Zkh != null) {
        paramVarArgs.d(3, this.Zkh);
      }
      if (this.Zki != null) {
        paramVarArgs.d(4, this.Zki);
      }
      paramVarArgs.bS(5, this.version);
      paramVarArgs.bS(6, this.Tqb);
      if (this.Zkj != null) {
        paramVarArgs.d(7, this.Zkj);
      }
      AppMethodBeat.o(258407);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label664;
      }
    }
    label664:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Zkg != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.Zkg);
      }
      i = paramInt;
      if (this.Zkh != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.Zkh);
      }
      paramInt = i;
      if (this.Zki != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.Zki);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.version) + i.a.a.b.b.a.cJ(6, this.Tqb);
      paramInt = i;
      if (this.Zkj != null) {
        paramInt = i + i.a.a.b.b.a.c(7, this.Zkj);
      }
      AppMethodBeat.o(258407);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(258407);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258407);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        abo localabo = (abo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258407);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localabo.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(258407);
          return 0;
        case 2: 
          localabo.Zkg = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(258407);
          return 0;
        case 3: 
          localabo.Zkh = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(258407);
          return 0;
        case 4: 
          localabo.Zki = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(258407);
          return 0;
        case 5: 
          localabo.version = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258407);
          return 0;
        case 6: 
          localabo.Tqb = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258407);
          return 0;
        }
        localabo.Zkj = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(258407);
        return 0;
      }
      AppMethodBeat.o(258407);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abo
 * JD-Core Version:    0.7.0.1
 */