package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ftp
  extends erp
{
  public String UserName;
  public int YKH;
  public String YOc;
  public LinkedList<dow> aaMZ;
  public int abRJ;
  public int abRK;
  public LinkedList<dkj> abRL;
  
  public ftp()
  {
    AppMethodBeat.i(155474);
    this.aaMZ = new LinkedList();
    this.abRL = new LinkedList();
    AppMethodBeat.o(155474);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155475);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.g(2, this.UserName);
      }
      paramVarArgs.bS(3, this.YKH);
      if (this.YOc != null) {
        paramVarArgs.g(4, this.YOc);
      }
      paramVarArgs.bS(5, this.abRJ);
      paramVarArgs.e(6, 8, this.aaMZ);
      paramVarArgs.bS(7, this.abRK);
      paramVarArgs.e(8, 8, this.abRL);
      AppMethodBeat.o(155475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label784;
      }
    }
    label784:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.UserName);
      }
      i += i.a.a.b.b.a.cJ(3, this.YKH);
      paramInt = i;
      if (this.YOc != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YOc);
      }
      i = i.a.a.b.b.a.cJ(5, this.abRJ);
      int j = i.a.a.a.c(6, 8, this.aaMZ);
      int k = i.a.a.b.b.a.cJ(7, this.abRK);
      int m = i.a.a.a.c(8, 8, this.abRL);
      AppMethodBeat.o(155475);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaMZ.clear();
        this.abRL.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(155475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ftp localftp = (ftp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155475);
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
            localftp.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155475);
          return 0;
        case 2: 
          localftp.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155475);
          return 0;
        case 3: 
          localftp.YKH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155475);
          return 0;
        case 4: 
          localftp.YOc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155475);
          return 0;
        case 5: 
          localftp.abRJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155475);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dow();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dow)localObject2).parseFrom((byte[])localObject1);
            }
            localftp.aaMZ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155475);
          return 0;
        case 7: 
          localftp.abRK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155475);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dkj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dkj)localObject2).parseFrom((byte[])localObject1);
          }
          localftp.abRL.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(155475);
        return 0;
      }
      AppMethodBeat.o(155475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ftp
 * JD-Core Version:    0.7.0.1
 */