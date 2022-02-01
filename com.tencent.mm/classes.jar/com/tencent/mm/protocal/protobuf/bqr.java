package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqr
  extends cvc
{
  public String GKK;
  public String GKL;
  public String GKO;
  public LinkedList<String> GLd;
  public String GLe;
  public LinkedList<String> GLf;
  public String cUM;
  public String duW;
  public int scene;
  public String signature;
  public String url;
  
  public bqr()
  {
    AppMethodBeat.i(82438);
    this.GLd = new LinkedList();
    this.GLf = new LinkedList();
    AppMethodBeat.o(82438);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82439);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.duW != null) {
        paramVarArgs.d(3, this.duW);
      }
      paramVarArgs.e(4, 1, this.GLd);
      if (this.cUM != null) {
        paramVarArgs.d(5, this.cUM);
      }
      if (this.GKK != null) {
        paramVarArgs.d(6, this.GKK);
      }
      if (this.signature != null) {
        paramVarArgs.d(7, this.signature);
      }
      if (this.GKL != null) {
        paramVarArgs.d(8, this.GKL);
      }
      paramVarArgs.aS(9, this.scene);
      if (this.GLe != null) {
        paramVarArgs.d(10, this.GLe);
      }
      paramVarArgs.e(11, 1, this.GLf);
      if (this.GKO != null) {
        paramVarArgs.d(12, this.GKO);
      }
      AppMethodBeat.o(82439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label966;
      }
    }
    label966:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.duW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.duW);
      }
      i += f.a.a.a.c(4, 1, this.GLd);
      paramInt = i;
      if (this.cUM != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.cUM);
      }
      i = paramInt;
      if (this.GKK != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GKK);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.signature);
      }
      i = paramInt;
      if (this.GKL != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GKL);
      }
      i += f.a.a.b.b.a.bz(9, this.scene);
      paramInt = i;
      if (this.GLe != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GLe);
      }
      i = paramInt + f.a.a.a.c(11, 1, this.GLf);
      paramInt = i;
      if (this.GKO != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GKO);
      }
      AppMethodBeat.o(82439);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GLd.clear();
        this.GLf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(82439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bqr localbqr = (bqr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82439);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqr.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82439);
          return 0;
        case 2: 
          localbqr.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 3: 
          localbqr.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 4: 
          localbqr.GLd.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(82439);
          return 0;
        case 5: 
          localbqr.cUM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 6: 
          localbqr.GKK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 7: 
          localbqr.signature = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 8: 
          localbqr.GKL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 9: 
          localbqr.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(82439);
          return 0;
        case 10: 
          localbqr.GLe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 11: 
          localbqr.GLf.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(82439);
          return 0;
        }
        localbqr.GKO = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(82439);
        return 0;
      }
      AppMethodBeat.o(82439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqr
 * JD-Core Version:    0.7.0.1
 */