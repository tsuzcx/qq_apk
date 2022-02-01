package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bik
  extends ckq
{
  public String DGa;
  public String DGb;
  public int DGc;
  public int DGd;
  public String DGe;
  public String DGf;
  public String dlB;
  public int nTM;
  public String packageName;
  public int scene;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123602);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dlB != null) {
        paramVarArgs.d(2, this.dlB);
      }
      if (this.DGa != null) {
        paramVarArgs.d(3, this.DGa);
      }
      paramVarArgs.aR(4, this.scene);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      if (this.DGb != null) {
        paramVarArgs.d(6, this.DGb);
      }
      paramVarArgs.aR(7, this.nTM);
      paramVarArgs.aR(8, this.DGc);
      paramVarArgs.aR(9, this.DGd);
      if (this.DGe != null) {
        paramVarArgs.d(10, this.DGe);
      }
      if (this.packageName != null) {
        paramVarArgs.d(11, this.packageName);
      }
      if (this.DGf != null) {
        paramVarArgs.d(12, this.DGf);
      }
      AppMethodBeat.o(123602);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label918;
      }
    }
    label918:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlB);
      }
      i = paramInt;
      if (this.DGa != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DGa);
      }
      i += f.a.a.b.b.a.bA(4, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt;
      if (this.DGb != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DGb);
      }
      i = i + f.a.a.b.b.a.bA(7, this.nTM) + f.a.a.b.b.a.bA(8, this.DGc) + f.a.a.b.b.a.bA(9, this.DGd);
      paramInt = i;
      if (this.DGe != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DGe);
      }
      i = paramInt;
      if (this.packageName != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.packageName);
      }
      paramInt = i;
      if (this.DGf != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DGf);
      }
      AppMethodBeat.o(123602);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123602);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bik localbik = (bik)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123602);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbik.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123602);
          return 0;
        case 2: 
          localbik.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 3: 
          localbik.DGa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 4: 
          localbik.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123602);
          return 0;
        case 5: 
          localbik.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 6: 
          localbik.DGb = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 7: 
          localbik.nTM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123602);
          return 0;
        case 8: 
          localbik.DGc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123602);
          return 0;
        case 9: 
          localbik.DGd = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123602);
          return 0;
        case 10: 
          localbik.DGe = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 11: 
          localbik.packageName = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123602);
          return 0;
        }
        localbik.DGf = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(123602);
        return 0;
      }
      AppMethodBeat.o(123602);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bik
 * JD-Core Version:    0.7.0.1
 */