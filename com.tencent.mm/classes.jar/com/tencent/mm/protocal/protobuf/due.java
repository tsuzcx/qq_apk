package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class due
  extends esc
{
  public float aaZL;
  public String aaZM;
  public String aaZN;
  public String aaZO;
  public LinkedList<fql> aasU;
  public com.tencent.mm.bx.b aauj;
  public int oOu;
  
  public due()
  {
    AppMethodBeat.i(120958);
    this.aasU = new LinkedList();
    AppMethodBeat.o(120958);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(120959);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(120959);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.oOu);
      paramVarArgs.e(3, 8, this.aasU);
      if (this.aauj != null) {
        paramVarArgs.d(4, this.aauj);
      }
      paramVarArgs.l(5, this.aaZL);
      if (this.aaZM != null) {
        paramVarArgs.g(6, this.aaZM);
      }
      if (this.aaZN != null) {
        paramVarArgs.g(7, this.aaZN);
      }
      if (this.aaZO != null) {
        paramVarArgs.g(8, this.aaZO);
      }
      AppMethodBeat.o(120959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label785;
      }
    }
    label785:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.oOu) + i.a.a.a.c(3, 8, this.aasU);
      paramInt = i;
      if (this.aauj != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.aauj);
      }
      i = paramInt + (i.a.a.b.b.a.ko(5) + 4);
      paramInt = i;
      if (this.aaZM != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaZM);
      }
      i = paramInt;
      if (this.aaZN != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aaZN);
      }
      paramInt = i;
      if (this.aaZO != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaZO);
      }
      AppMethodBeat.o(120959);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aasU.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(120959);
          throw paramVarArgs;
        }
        AppMethodBeat.o(120959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        due localdue = (due)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(120959);
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
            localdue.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(120959);
          return 0;
        case 2: 
          localdue.oOu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(120959);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fql();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fql)localObject2).parseFrom((byte[])localObject1);
            }
            localdue.aasU.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(120959);
          return 0;
        case 4: 
          localdue.aauj = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(120959);
          return 0;
        case 5: 
          localdue.aaZL = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(120959);
          return 0;
        case 6: 
          localdue.aaZM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(120959);
          return 0;
        case 7: 
          localdue.aaZN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(120959);
          return 0;
        }
        localdue.aaZO = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(120959);
        return 0;
      }
      AppMethodBeat.o(120959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.due
 * JD-Core Version:    0.7.0.1
 */