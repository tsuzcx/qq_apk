package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cik
  extends cvc
{
  public bb FPa;
  public String FXe;
  public String FXf;
  public String FXg;
  public String FXh;
  public String GsR;
  public String Hcn;
  public String Hco;
  public String Hcp;
  public String Hcq;
  public String Hcr;
  public String iht;
  public String ufi;
  public String uiR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91571);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.iht != null) {
        paramVarArgs.d(2, this.iht);
      }
      if (this.Hcn != null) {
        paramVarArgs.d(3, this.Hcn);
      }
      if (this.GsR != null) {
        paramVarArgs.d(4, this.GsR);
      }
      if (this.FXe != null) {
        paramVarArgs.d(5, this.FXe);
      }
      if (this.Hco != null) {
        paramVarArgs.d(6, this.Hco);
      }
      if (this.FXf != null) {
        paramVarArgs.d(7, this.FXf);
      }
      if (this.FXg != null) {
        paramVarArgs.d(8, this.FXg);
      }
      if (this.FXh != null) {
        paramVarArgs.d(9, this.FXh);
      }
      if (this.Hcp != null) {
        paramVarArgs.d(10, this.Hcp);
      }
      if (this.FPa != null)
      {
        paramVarArgs.lC(11, this.FPa.computeSize());
        this.FPa.writeFields(paramVarArgs);
      }
      if (this.Hcq != null) {
        paramVarArgs.d(12, this.Hcq);
      }
      if (this.ufi != null) {
        paramVarArgs.d(13, this.ufi);
      }
      if (this.uiR != null) {
        paramVarArgs.d(14, this.uiR);
      }
      if (this.Hcr != null) {
        paramVarArgs.d(15, this.Hcr);
      }
      AppMethodBeat.o(91571);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1266;
      }
    }
    label1266:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iht);
      }
      i = paramInt;
      if (this.Hcn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hcn);
      }
      paramInt = i;
      if (this.GsR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GsR);
      }
      i = paramInt;
      if (this.FXe != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FXe);
      }
      paramInt = i;
      if (this.Hco != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hco);
      }
      i = paramInt;
      if (this.FXf != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FXf);
      }
      paramInt = i;
      if (this.FXg != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FXg);
      }
      i = paramInt;
      if (this.FXh != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FXh);
      }
      paramInt = i;
      if (this.Hcp != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Hcp);
      }
      i = paramInt;
      if (this.FPa != null) {
        i = paramInt + f.a.a.a.lB(11, this.FPa.computeSize());
      }
      paramInt = i;
      if (this.Hcq != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Hcq);
      }
      i = paramInt;
      if (this.ufi != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.ufi);
      }
      paramInt = i;
      if (this.uiR != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.uiR);
      }
      i = paramInt;
      if (this.Hcr != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.Hcr);
      }
      AppMethodBeat.o(91571);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91571);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cik localcik = (cik)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91571);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcik.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91571);
          return 0;
        case 2: 
          localcik.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 3: 
          localcik.Hcn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 4: 
          localcik.GsR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 5: 
          localcik.FXe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 6: 
          localcik.Hco = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 7: 
          localcik.FXf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 8: 
          localcik.FXg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 9: 
          localcik.FXh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 10: 
          localcik.Hcp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcik.FPa = ((bb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91571);
          return 0;
        case 12: 
          localcik.Hcq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 13: 
          localcik.ufi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 14: 
          localcik.uiR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91571);
          return 0;
        }
        localcik.Hcr = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91571);
        return 0;
      }
      AppMethodBeat.o(91571);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cik
 * JD-Core Version:    0.7.0.1
 */