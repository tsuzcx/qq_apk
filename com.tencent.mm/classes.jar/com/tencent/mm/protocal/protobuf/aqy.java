package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqy
  extends cvw
{
  public alw GDR;
  public float GHH;
  public float GHI;
  public int GHJ;
  public FinderObjectDesc GHK;
  public long GHL;
  public LinkedList<String> GHM;
  public String clientId;
  public float dBu;
  public float dzE;
  public int originalFlag;
  public String refObjectNonceId;
  public String username;
  
  public aqy()
  {
    AppMethodBeat.i(169036);
    this.GHM = new LinkedList();
    AppMethodBeat.o(169036);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169037);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.GHK != null)
      {
        paramVarArgs.lJ(3, this.GHK.computeSize());
        this.GHK.writeFields(paramVarArgs);
      }
      if (this.clientId != null) {
        paramVarArgs.d(4, this.clientId);
      }
      paramVarArgs.aZ(5, this.GHL);
      if (this.refObjectNonceId != null) {
        paramVarArgs.d(6, this.refObjectNonceId);
      }
      if (this.GDR != null)
      {
        paramVarArgs.lJ(7, this.GDR.computeSize());
        this.GDR.writeFields(paramVarArgs);
      }
      paramVarArgs.y(8, this.dBu);
      paramVarArgs.y(9, this.dzE);
      paramVarArgs.y(10, this.GHH);
      paramVarArgs.y(11, this.GHI);
      paramVarArgs.aS(12, this.GHJ);
      paramVarArgs.e(13, 1, this.GHM);
      paramVarArgs.aS(14, this.originalFlag);
      AppMethodBeat.o(169037);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1190;
      }
    }
    label1190:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.GHK != null) {
        i = paramInt + f.a.a.a.lI(3, this.GHK.computeSize());
      }
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.clientId);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.GHL);
      paramInt = i;
      if (this.refObjectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.refObjectNonceId);
      }
      i = paramInt;
      if (this.GDR != null) {
        i = paramInt + f.a.a.a.lI(7, this.GDR.computeSize());
      }
      paramInt = f.a.a.b.b.a.amE(8);
      int j = f.a.a.b.b.a.amE(9);
      int k = f.a.a.b.b.a.amE(10);
      int m = f.a.a.b.b.a.amE(11);
      int n = f.a.a.b.b.a.bz(12, this.GHJ);
      int i1 = f.a.a.a.c(13, 1, this.GHM);
      int i2 = f.a.a.b.b.a.bz(14, this.originalFlag);
      AppMethodBeat.o(169037);
      return i + paramInt + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GHM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169037);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aqy localaqy = (aqy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169037);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 2: 
          localaqy.username = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObjectDesc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObjectDesc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqy.GHK = ((FinderObjectDesc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 4: 
          localaqy.clientId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 5: 
          localaqy.GHL = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169037);
          return 0;
        case 6: 
          localaqy.refObjectNonceId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqy.GDR = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 8: 
          localaqy.dBu = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(169037);
          return 0;
        case 9: 
          localaqy.dzE = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(169037);
          return 0;
        case 10: 
          localaqy.GHH = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(169037);
          return 0;
        case 11: 
          localaqy.GHI = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(169037);
          return 0;
        case 12: 
          localaqy.GHJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169037);
          return 0;
        case 13: 
          localaqy.GHM.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(169037);
          return 0;
        }
        localaqy.originalFlag = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169037);
        return 0;
      }
      AppMethodBeat.o(169037);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqy
 * JD-Core Version:    0.7.0.1
 */