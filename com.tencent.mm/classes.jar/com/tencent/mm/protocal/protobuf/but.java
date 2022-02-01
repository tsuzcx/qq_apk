package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class but
  extends erp
{
  public atz CJv;
  public b aacm;
  public b aacn;
  public b aaco;
  public int limit;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259116);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CJv != null)
      {
        paramVarArgs.qD(2, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.scene);
      if (this.aacm != null) {
        paramVarArgs.d(4, this.aacm);
      }
      if (this.aacn != null) {
        paramVarArgs.d(5, this.aacn);
      }
      if (this.aaco != null) {
        paramVarArgs.d(6, this.aaco);
      }
      paramVarArgs.bS(7, this.limit);
      AppMethodBeat.o(259116);
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
      int i = paramInt;
      if (this.CJv != null) {
        i = paramInt + i.a.a.a.qC(2, this.CJv.computeSize());
      }
      i += i.a.a.b.b.a.cJ(3, this.scene);
      paramInt = i;
      if (this.aacm != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.aacm);
      }
      i = paramInt;
      if (this.aacn != null) {
        i = paramInt + i.a.a.b.b.a.c(5, this.aacn);
      }
      paramInt = i;
      if (this.aaco != null) {
        paramInt = i + i.a.a.b.b.a.c(6, this.aaco);
      }
      i = i.a.a.b.b.a.cJ(7, this.limit);
      AppMethodBeat.o(259116);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259116);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        but localbut = (but)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259116);
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
            localbut.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259116);
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
            localbut.CJv = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259116);
          return 0;
        case 3: 
          localbut.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259116);
          return 0;
        case 4: 
          localbut.aacm = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259116);
          return 0;
        case 5: 
          localbut.aacn = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259116);
          return 0;
        case 6: 
          localbut.aaco = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259116);
          return 0;
        }
        localbut.limit = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259116);
        return 0;
      }
      AppMethodBeat.o(259116);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.but
 * JD-Core Version:    0.7.0.1
 */