package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmh
  extends cpx
{
  public LinkedList<String> FbE;
  public String FbF;
  public LinkedList<String> FbG;
  public String Fbl;
  public String Fbm;
  public String Fbp;
  public String cJz;
  public String djj;
  public int scene;
  public String signature;
  public String url;
  
  public bmh()
  {
    AppMethodBeat.i(82438);
    this.FbE = new LinkedList();
    this.FbG = new LinkedList();
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
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.djj != null) {
        paramVarArgs.d(3, this.djj);
      }
      paramVarArgs.e(4, 1, this.FbE);
      if (this.cJz != null) {
        paramVarArgs.d(5, this.cJz);
      }
      if (this.Fbl != null) {
        paramVarArgs.d(6, this.Fbl);
      }
      if (this.signature != null) {
        paramVarArgs.d(7, this.signature);
      }
      if (this.Fbm != null) {
        paramVarArgs.d(8, this.Fbm);
      }
      paramVarArgs.aR(9, this.scene);
      if (this.FbF != null) {
        paramVarArgs.d(10, this.FbF);
      }
      paramVarArgs.e(11, 1, this.FbG);
      if (this.Fbp != null) {
        paramVarArgs.d(12, this.Fbp);
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
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.djj);
      }
      i += f.a.a.a.c(4, 1, this.FbE);
      paramInt = i;
      if (this.cJz != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.cJz);
      }
      i = paramInt;
      if (this.Fbl != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Fbl);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.signature);
      }
      i = paramInt;
      if (this.Fbm != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Fbm);
      }
      i += f.a.a.b.b.a.bx(9, this.scene);
      paramInt = i;
      if (this.FbF != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FbF);
      }
      i = paramInt + f.a.a.a.c(11, 1, this.FbG);
      paramInt = i;
      if (this.Fbp != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Fbp);
      }
      AppMethodBeat.o(82439);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FbE.clear();
        this.FbG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bmh localbmh = (bmh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82439);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmh.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82439);
          return 0;
        case 2: 
          localbmh.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 3: 
          localbmh.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 4: 
          localbmh.FbE.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(82439);
          return 0;
        case 5: 
          localbmh.cJz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 6: 
          localbmh.Fbl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 7: 
          localbmh.signature = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 8: 
          localbmh.Fbm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 9: 
          localbmh.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(82439);
          return 0;
        case 10: 
          localbmh.FbF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82439);
          return 0;
        case 11: 
          localbmh.FbG.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(82439);
          return 0;
        }
        localbmh.Fbp = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(82439);
        return 0;
      }
      AppMethodBeat.o(82439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmh
 * JD-Core Version:    0.7.0.1
 */