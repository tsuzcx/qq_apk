package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgq
  extends erp
{
  public String aaLH;
  public String aaLI;
  public String aaLJ;
  public String query;
  public int source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153288);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aaLH != null) {
        paramVarArgs.g(2, this.aaLH);
      }
      if (this.query != null) {
        paramVarArgs.g(3, this.query);
      }
      if (this.aaLI != null) {
        paramVarArgs.g(4, this.aaLI);
      }
      if (this.aaLJ != null) {
        paramVarArgs.g(5, this.aaLJ);
      }
      paramVarArgs.bS(6, this.source);
      AppMethodBeat.o(153288);
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
      if (this.aaLH != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaLH);
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.query);
      }
      paramInt = i;
      if (this.aaLI != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaLI);
      }
      i = paramInt;
      if (this.aaLJ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaLJ);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.source);
      AppMethodBeat.o(153288);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153288);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dgq localdgq = (dgq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153288);
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
            localdgq.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(153288);
          return 0;
        case 2: 
          localdgq.aaLH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153288);
          return 0;
        case 3: 
          localdgq.query = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153288);
          return 0;
        case 4: 
          localdgq.aaLI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153288);
          return 0;
        case 5: 
          localdgq.aaLJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153288);
          return 0;
        }
        localdgq.source = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(153288);
        return 0;
      }
      AppMethodBeat.o(153288);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgq
 * JD-Core Version:    0.7.0.1
 */