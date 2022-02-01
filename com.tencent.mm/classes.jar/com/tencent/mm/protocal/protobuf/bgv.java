package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgv
  extends esc
{
  public LinkedList<bfl> ZKa;
  public int ZQi;
  public int ZQj;
  public bkj ZQk;
  public fmc ZQl;
  public String ZQm;
  
  public bgv()
  {
    AppMethodBeat.i(258009);
    this.ZKa = new LinkedList();
    AppMethodBeat.o(258009);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258013);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ZQi);
      paramVarArgs.e(3, 8, this.ZKa);
      paramVarArgs.bS(4, this.ZQj);
      if (this.ZQk != null)
      {
        paramVarArgs.qD(5, this.ZQk.computeSize());
        this.ZQk.writeFields(paramVarArgs);
      }
      if (this.ZQl != null)
      {
        paramVarArgs.qD(6, this.ZQl.computeSize());
        this.ZQl.writeFields(paramVarArgs);
      }
      if (this.ZQm != null) {
        paramVarArgs.g(7, this.ZQm);
      }
      AppMethodBeat.o(258013);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label818;
      }
    }
    label818:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ZQi) + i.a.a.a.c(3, 8, this.ZKa) + i.a.a.b.b.a.cJ(4, this.ZQj);
      paramInt = i;
      if (this.ZQk != null) {
        paramInt = i + i.a.a.a.qC(5, this.ZQk.computeSize());
      }
      i = paramInt;
      if (this.ZQl != null) {
        i = paramInt + i.a.a.a.qC(6, this.ZQl.computeSize());
      }
      paramInt = i;
      if (this.ZQm != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ZQm);
      }
      AppMethodBeat.o(258013);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZKa.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258013);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bgv localbgv = (bgv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258013);
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
            localbgv.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258013);
          return 0;
        case 2: 
          localbgv.ZQi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258013);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfl)localObject2).parseFrom((byte[])localObject1);
            }
            localbgv.ZKa.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258013);
          return 0;
        case 4: 
          localbgv.ZQj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258013);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bkj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bkj)localObject2).parseFrom((byte[])localObject1);
            }
            localbgv.ZQk = ((bkj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258013);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmc)localObject2).parseFrom((byte[])localObject1);
            }
            localbgv.ZQl = ((fmc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258013);
          return 0;
        }
        localbgv.ZQm = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258013);
        return 0;
      }
      AppMethodBeat.o(258013);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgv
 * JD-Core Version:    0.7.0.1
 */