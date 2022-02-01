package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dab
  extends cvw
{
  public int Gdm;
  public String GjV;
  public String Grr;
  public String HJF;
  public int doj;
  public String dwb;
  public int scene;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91683);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Grr != null) {
        paramVarArgs.d(2, this.Grr);
      }
      if (this.dwb != null) {
        paramVarArgs.d(3, this.dwb);
      }
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      if (this.HJF != null) {
        paramVarArgs.d(5, this.HJF);
      }
      paramVarArgs.aS(6, this.scene);
      paramVarArgs.aS(7, this.doj);
      if (this.GjV != null) {
        paramVarArgs.d(8, this.GjV);
      }
      paramVarArgs.aS(9, this.Gdm);
      AppMethodBeat.o(91683);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label750;
      }
    }
    label750:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Grr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Grr);
      }
      i = paramInt;
      if (this.dwb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dwb);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.url);
      }
      i = paramInt;
      if (this.HJF != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HJF);
      }
      i = i + f.a.a.b.b.a.bz(6, this.scene) + f.a.a.b.b.a.bz(7, this.doj);
      paramInt = i;
      if (this.GjV != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GjV);
      }
      i = f.a.a.b.b.a.bz(9, this.Gdm);
      AppMethodBeat.o(91683);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91683);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dab localdab = (dab)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91683);
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
            localdab.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91683);
          return 0;
        case 2: 
          localdab.Grr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 3: 
          localdab.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 4: 
          localdab.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 5: 
          localdab.HJF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 6: 
          localdab.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91683);
          return 0;
        case 7: 
          localdab.doj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91683);
          return 0;
        case 8: 
          localdab.GjV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91683);
          return 0;
        }
        localdab.Gdm = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91683);
        return 0;
      }
      AppMethodBeat.o(91683);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dab
 * JD-Core Version:    0.7.0.1
 */