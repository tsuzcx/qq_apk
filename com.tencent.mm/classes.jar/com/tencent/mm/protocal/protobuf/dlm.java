package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlm
  extends erp
{
  public int Zdz;
  public long aaRB;
  public long aaRC;
  public long aaRD;
  public int offset;
  public String query;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169915);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.aaRB);
      paramVarArgs.bv(3, this.aaRC);
      if (this.query != null) {
        paramVarArgs.g(4, this.query);
      }
      paramVarArgs.bS(5, this.offset);
      paramVarArgs.bS(6, this.Zdz);
      paramVarArgs.bv(7, this.aaRD);
      AppMethodBeat.o(169915);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label572;
      }
    }
    label572:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.aaRB) + i.a.a.b.b.a.q(3, this.aaRC);
      paramInt = i;
      if (this.query != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.query);
      }
      i = i.a.a.b.b.a.cJ(5, this.offset);
      int j = i.a.a.b.b.a.cJ(6, this.Zdz);
      int k = i.a.a.b.b.a.q(7, this.aaRD);
      AppMethodBeat.o(169915);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169915);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dlm localdlm = (dlm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169915);
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
            localdlm.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(169915);
          return 0;
        case 2: 
          localdlm.aaRB = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(169915);
          return 0;
        case 3: 
          localdlm.aaRC = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(169915);
          return 0;
        case 4: 
          localdlm.query = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169915);
          return 0;
        case 5: 
          localdlm.offset = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169915);
          return 0;
        case 6: 
          localdlm.Zdz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169915);
          return 0;
        }
        localdlm.aaRD = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(169915);
        return 0;
      }
      AppMethodBeat.o(169915);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlm
 * JD-Core Version:    0.7.0.1
 */