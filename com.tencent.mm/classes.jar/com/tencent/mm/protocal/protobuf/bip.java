package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bip
  extends ckq
{
  public String DFR;
  public String DFS;
  public String DFV;
  public LinkedList<String> DGk;
  public String DGl;
  public LinkedList<String> DGm;
  public String cMo;
  public String dlB;
  public int scene;
  public String signature;
  public String url;
  
  public bip()
  {
    AppMethodBeat.i(82438);
    this.DGk = new LinkedList();
    this.DGm = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.dlB != null) {
        paramVarArgs.d(3, this.dlB);
      }
      paramVarArgs.e(4, 1, this.DGk);
      if (this.cMo != null) {
        paramVarArgs.d(5, this.cMo);
      }
      if (this.DFR != null) {
        paramVarArgs.d(6, this.DFR);
      }
      if (this.signature != null) {
        paramVarArgs.d(7, this.signature);
      }
      if (this.DFS != null) {
        paramVarArgs.d(8, this.DFS);
      }
      paramVarArgs.aR(9, this.scene);
      if (this.DGl != null) {
        paramVarArgs.d(10, this.DGl);
      }
      paramVarArgs.e(11, 1, this.DGm);
      if (this.DFV != null) {
        paramVarArgs.d(12, this.DFV);
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
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dlB);
      }
      i += f.a.a.a.c(4, 1, this.DGk);
      paramInt = i;
      if (this.cMo != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.cMo);
      }
      i = paramInt;
      if (this.DFR != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DFR);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.signature);
      }
      i = paramInt;
      if (this.DFS != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DFS);
      }
      i += f.a.a.b.b.a.bA(9, this.scene);
      paramInt = i;
      if (this.DGl != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DGl);
      }
      i = paramInt + f.a.a.a.c(11, 1, this.DGm);
      paramInt = i;
      if (this.DFV != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DFV);
      }
      AppMethodBeat.o(82439);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DGk.clear();
        this.DGm.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(82439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bip localbip = (bip)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82439);
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
            localbip.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82439);
          return 0;
        case 2: 
          localbip.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 3: 
          localbip.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 4: 
          localbip.DGk.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(82439);
          return 0;
        case 5: 
          localbip.cMo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 6: 
          localbip.DFR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 7: 
          localbip.signature = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 8: 
          localbip.DFS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 9: 
          localbip.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(82439);
          return 0;
        case 10: 
          localbip.DGl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 11: 
          localbip.DGm.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(82439);
          return 0;
        }
        localbip.DFV = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(82439);
        return 0;
      }
      AppMethodBeat.o(82439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bip
 * JD-Core Version:    0.7.0.1
 */