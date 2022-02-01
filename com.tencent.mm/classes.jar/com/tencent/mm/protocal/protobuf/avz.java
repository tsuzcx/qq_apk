package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avz
  extends erp
{
  public atz YIY;
  public String YIZ;
  public String ZGh;
  public long ZGi;
  public long ZGj;
  public String ZGk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257459);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YIY != null)
      {
        paramVarArgs.qD(2, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(3, this.YIZ);
      }
      if (this.ZGh != null) {
        paramVarArgs.g(4, this.ZGh);
      }
      paramVarArgs.bv(5, this.ZGi);
      paramVarArgs.bv(6, this.ZGj);
      if (this.ZGk != null) {
        paramVarArgs.g(7, this.ZGk);
      }
      AppMethodBeat.o(257459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label686;
      }
    }
    label686:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = paramInt;
      if (this.YIZ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YIZ);
      }
      paramInt = i;
      if (this.ZGh != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZGh);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.ZGi) + i.a.a.b.b.a.q(6, this.ZGj);
      paramInt = i;
      if (this.ZGk != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ZGk);
      }
      AppMethodBeat.o(257459);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257459);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        avz localavz = (avz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257459);
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
            localavz.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257459);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localavz.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257459);
          return 0;
        case 3: 
          localavz.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257459);
          return 0;
        case 4: 
          localavz.ZGh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257459);
          return 0;
        case 5: 
          localavz.ZGi = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257459);
          return 0;
        case 6: 
          localavz.ZGj = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257459);
          return 0;
        }
        localavz.ZGk = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257459);
        return 0;
      }
      AppMethodBeat.o(257459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avz
 * JD-Core Version:    0.7.0.1
 */