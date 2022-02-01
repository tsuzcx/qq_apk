package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class sn
  extends cld
{
  public String Aar;
  public cgx CTW;
  public boolean CUo;
  public String CUp;
  public int CUq;
  public LinkedList<Integer> CUr;
  public String CUs;
  public int CUt;
  public int CUu;
  public int dcG;
  public String desc;
  public String mVR;
  public String nTK;
  public String nti;
  public String vzM;
  
  public sn()
  {
    AppMethodBeat.i(72433);
    this.CUr = new LinkedList();
    AppMethodBeat.o(72433);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72434);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72434);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dcG);
      if (this.nTK != null) {
        paramVarArgs.d(3, this.nTK);
      }
      paramVarArgs.bg(4, this.CUo);
      if (this.vzM != null) {
        paramVarArgs.d(5, this.vzM);
      }
      if (this.CUp != null) {
        paramVarArgs.d(6, this.CUp);
      }
      if (this.mVR != null) {
        paramVarArgs.d(7, this.mVR);
      }
      paramVarArgs.aR(8, this.CUq);
      if (this.desc != null) {
        paramVarArgs.d(9, this.desc);
      }
      if (this.Aar != null) {
        paramVarArgs.d(10, this.Aar);
      }
      paramVarArgs.e(11, 2, this.CUr);
      if (this.CUs != null) {
        paramVarArgs.d(12, this.CUs);
      }
      if (this.nti != null) {
        paramVarArgs.d(13, this.nti);
      }
      paramVarArgs.aR(14, this.CUt);
      paramVarArgs.aR(15, this.CUu);
      if (this.CTW != null)
      {
        paramVarArgs.kX(16, this.CTW.computeSize());
        this.CTW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1293;
      }
    }
    label1293:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt + (f.a.a.b.b.a.fY(4) + 1);
      paramInt = i;
      if (this.vzM != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.vzM);
      }
      i = paramInt;
      if (this.CUp != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.CUp);
      }
      paramInt = i;
      if (this.mVR != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.mVR);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.CUq);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.desc);
      }
      i = paramInt;
      if (this.Aar != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Aar);
      }
      i += f.a.a.a.c(11, 2, this.CUr);
      paramInt = i;
      if (this.CUs != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.CUs);
      }
      i = paramInt;
      if (this.nti != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.nti);
      }
      i = i + f.a.a.b.b.a.bA(14, this.CUt) + f.a.a.b.b.a.bA(15, this.CUu);
      paramInt = i;
      if (this.CTW != null) {
        paramInt = i + f.a.a.a.kW(16, this.CTW.computeSize());
      }
      AppMethodBeat.o(72434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CUr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72434);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72434);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sn localsn = (sn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72434);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72434);
          return 0;
        case 2: 
          localsn.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72434);
          return 0;
        case 3: 
          localsn.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 4: 
          localsn.CUo = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(72434);
          return 0;
        case 5: 
          localsn.vzM = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 6: 
          localsn.CUp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 7: 
          localsn.mVR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 8: 
          localsn.CUq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72434);
          return 0;
        case 9: 
          localsn.desc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 10: 
          localsn.Aar = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 11: 
          localsn.CUr.add(Integer.valueOf(((f.a.a.a.a)localObject1).KhF.xS()));
          AppMethodBeat.o(72434);
          return 0;
        case 12: 
          localsn.CUs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 13: 
          localsn.nti = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 14: 
          localsn.CUt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72434);
          return 0;
        case 15: 
          localsn.CUu = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72434);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cgx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cgx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsn.CTW = ((cgx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72434);
        return 0;
      }
      AppMethodBeat.o(72434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sn
 * JD-Core Version:    0.7.0.1
 */