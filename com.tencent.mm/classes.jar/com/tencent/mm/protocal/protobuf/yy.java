package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yy
  extends cvw
{
  public String FNL;
  public int FXt;
  public String FZa;
  public int GqS;
  public String GqT;
  public LinkedList<yx> GqU;
  public dci GqV;
  public ddo GqW;
  public int scene;
  
  public yy()
  {
    AppMethodBeat.i(124474);
    this.GqU = new LinkedList();
    AppMethodBeat.o(124474);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GqS);
      if (this.GqT != null) {
        paramVarArgs.d(3, this.GqT);
      }
      if (this.FZa != null) {
        paramVarArgs.d(4, this.FZa);
      }
      if (this.FNL != null) {
        paramVarArgs.d(5, this.FNL);
      }
      paramVarArgs.e(6, 8, this.GqU);
      paramVarArgs.aS(7, this.scene);
      paramVarArgs.aS(8, this.FXt);
      if (this.GqV != null)
      {
        paramVarArgs.lJ(9, this.GqV.computeSize());
        this.GqV.writeFields(paramVarArgs);
      }
      if (this.GqW != null)
      {
        paramVarArgs.lJ(10, this.GqW.computeSize());
        this.GqW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1078;
      }
    }
    label1078:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GqS);
      paramInt = i;
      if (this.GqT != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GqT);
      }
      i = paramInt;
      if (this.FZa != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FZa);
      }
      paramInt = i;
      if (this.FNL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FNL);
      }
      i = paramInt + f.a.a.a.c(6, 8, this.GqU) + f.a.a.b.b.a.bz(7, this.scene) + f.a.a.b.b.a.bz(8, this.FXt);
      paramInt = i;
      if (this.GqV != null) {
        paramInt = i + f.a.a.a.lI(9, this.GqV.computeSize());
      }
      i = paramInt;
      if (this.GqW != null) {
        i = paramInt + f.a.a.a.lI(10, this.GqW.computeSize());
      }
      AppMethodBeat.o(124475);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GqU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yy localyy = (yy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124475);
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
            localyy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        case 2: 
          localyy.GqS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124475);
          return 0;
        case 3: 
          localyy.GqT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 4: 
          localyy.FZa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 5: 
          localyy.FNL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyy.GqU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        case 7: 
          localyy.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124475);
          return 0;
        case 8: 
          localyy.FXt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124475);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dci();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dci)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyy.GqV = ((dci)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ddo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ddo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyy.GqW = ((ddo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124475);
        return 0;
      }
      AppMethodBeat.o(124475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yy
 * JD-Core Version:    0.7.0.1
 */