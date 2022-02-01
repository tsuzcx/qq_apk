package com.tencent.mm.protocal.protobuf.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public aa aciQ;
  public z aciX;
  public long aciY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259705);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.aciX != null)
      {
        paramVarArgs.qD(2, this.aciX.computeSize());
        this.aciX.writeFields(paramVarArgs);
      }
      if (this.aciQ != null)
      {
        paramVarArgs.qD(3, this.aciQ.computeSize());
        this.aciQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(4, this.aciY);
      AppMethodBeat.o(259705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label522;
      }
    }
    label522:
    for (int i = i.a.a.b.b.a.h(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aciX != null) {
        paramInt = i + i.a.a.a.qC(2, this.aciX.computeSize());
      }
      i = paramInt;
      if (this.aciQ != null) {
        i = paramInt + i.a.a.a.qC(3, this.aciQ.computeSize());
      }
      paramInt = i.a.a.b.b.a.q(4, this.aciY);
      AppMethodBeat.o(259705);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259705);
          return -1;
        case 1: 
          locale.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259705);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new z();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((z)localObject2).parseFrom((byte[])localObject1);
            }
            locale.aciX = ((z)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259705);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aa();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aa)localObject2).parseFrom((byte[])localObject1);
            }
            locale.aciQ = ((aa)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259705);
          return 0;
        }
        locale.aciY = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(259705);
        return 0;
      }
      AppMethodBeat.o(259705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.a.e
 * JD-Core Version:    0.7.0.1
 */