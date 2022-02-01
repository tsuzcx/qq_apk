package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eat
  extends esc
{
  public String AesKey;
  public String ZBp;
  public String abfZ;
  public int abgd;
  public String abge;
  public int abgf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258424);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258424);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abfZ != null) {
        paramVarArgs.g(2, this.abfZ);
      }
      if (this.ZBp != null) {
        paramVarArgs.g(3, this.ZBp);
      }
      if (this.AesKey != null) {
        paramVarArgs.g(4, this.AesKey);
      }
      paramVarArgs.bS(6, this.abgd);
      if (this.abge != null) {
        paramVarArgs.g(8, this.abge);
      }
      paramVarArgs.bS(9, this.abgf);
      AppMethodBeat.o(258424);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label676;
      }
    }
    label676:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abfZ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abfZ);
      }
      i = paramInt;
      if (this.ZBp != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZBp);
      }
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.AesKey);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.abgd);
      paramInt = i;
      if (this.abge != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abge);
      }
      i = i.a.a.b.b.a.cJ(9, this.abgf);
      AppMethodBeat.o(258424);
      return paramInt + i;
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(258424);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258424);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eat localeat = (eat)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 5: 
        case 7: 
        default: 
          AppMethodBeat.o(258424);
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
            localeat.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(258424);
          return 0;
        case 2: 
          localeat.abfZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258424);
          return 0;
        case 3: 
          localeat.ZBp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258424);
          return 0;
        case 4: 
          localeat.AesKey = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258424);
          return 0;
        case 6: 
          localeat.abgd = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258424);
          return 0;
        case 8: 
          localeat.abge = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258424);
          return 0;
        }
        localeat.abgf = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258424);
        return 0;
      }
      AppMethodBeat.o(258424);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eat
 * JD-Core Version:    0.7.0.1
 */