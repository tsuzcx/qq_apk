package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brl
  extends cvw
{
  public LinkedList<String> HeE;
  public String HeF;
  public LinkedList<String> HeG;
  public String Hel;
  public String Hem;
  public String Hep;
  public String cVJ;
  public String dwb;
  public int scene;
  public String signature;
  public String url;
  
  public brl()
  {
    AppMethodBeat.i(82438);
    this.HeE = new LinkedList();
    this.HeG = new LinkedList();
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
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.dwb != null) {
        paramVarArgs.d(3, this.dwb);
      }
      paramVarArgs.e(4, 1, this.HeE);
      if (this.cVJ != null) {
        paramVarArgs.d(5, this.cVJ);
      }
      if (this.Hel != null) {
        paramVarArgs.d(6, this.Hel);
      }
      if (this.signature != null) {
        paramVarArgs.d(7, this.signature);
      }
      if (this.Hem != null) {
        paramVarArgs.d(8, this.Hem);
      }
      paramVarArgs.aS(9, this.scene);
      if (this.HeF != null) {
        paramVarArgs.d(10, this.HeF);
      }
      paramVarArgs.e(11, 1, this.HeG);
      if (this.Hep != null) {
        paramVarArgs.d(12, this.Hep);
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
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.dwb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dwb);
      }
      i += f.a.a.a.c(4, 1, this.HeE);
      paramInt = i;
      if (this.cVJ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.cVJ);
      }
      i = paramInt;
      if (this.Hel != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Hel);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.signature);
      }
      i = paramInt;
      if (this.Hem != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Hem);
      }
      i += f.a.a.b.b.a.bz(9, this.scene);
      paramInt = i;
      if (this.HeF != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.HeF);
      }
      i = paramInt + f.a.a.a.c(11, 1, this.HeG);
      paramInt = i;
      if (this.Hep != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Hep);
      }
      AppMethodBeat.o(82439);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HeE.clear();
        this.HeG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(82439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brl localbrl = (brl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82439);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrl.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82439);
          return 0;
        case 2: 
          localbrl.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 3: 
          localbrl.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 4: 
          localbrl.HeE.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(82439);
          return 0;
        case 5: 
          localbrl.cVJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 6: 
          localbrl.Hel = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 7: 
          localbrl.signature = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 8: 
          localbrl.Hem = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 9: 
          localbrl.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(82439);
          return 0;
        case 10: 
          localbrl.HeF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 11: 
          localbrl.HeG.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(82439);
          return 0;
        }
        localbrl.Hep = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(82439);
        return 0;
      }
      AppMethodBeat.o(82439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brl
 * JD-Core Version:    0.7.0.1
 */